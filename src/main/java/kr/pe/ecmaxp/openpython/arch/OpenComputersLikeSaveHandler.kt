package kr.pe.ecmaxp.openpython.arch

import li.cil.oc.api.machine.MachineHost
import net.minecraft.nbt.CompressedStreamTools
import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.common.DimensionManager
import net.minecraftforge.event.world.ChunkDataEvent
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent
import java.io.*

@Suppress("unused")
object OpenComputersLikeSaveHandler {
    // li.cil.oc.common.SaveHandler
    var cachedSavePathName: String? = null

    val savePathName: String
        get() = cachedSavePathName ?: run {
            cachedSavePathName = try {
                val cls = Class.forName("li.cil.oc.Settings")
                val method = cls.getMethod("savePath")
                method.invoke(cls) as String
            } catch (e: Exception) {
                "opencomputers/"
            }

            cachedSavePathName!!
        }

    val savePath get() = File(DimensionManager.getCurrentSaveRootDirectory(), savePathName)
    val statePath get() = File(savePath, "state")
    val saveData = HashMap<Int, HashMap<Pair<Int, Int>, HashMap<String, ByteArray>>>()

    @Synchronized
    fun scheduleSave(host: MachineHost, nbt: NBTTagCompound, name: String, nbtData: NBTTagCompound) {
        val baos = ByteArrayOutputStream()
        val dos = DataOutputStream(baos)
        CompressedStreamTools.write(nbtData, dos)
        val data = baos.toByteArray()
        return scheduleSave(host, nbt, name, data)
    }

    @Synchronized
    fun scheduleSave(host: MachineHost, nbt: NBTTagCompound, name: String, data: ByteArray) {
        val world = host.world()!!
        val dimension = world.provider.dimension
        val chunkPos = Pair(
                host.xPosition().toInt() shr 4,
                host.zPosition().toInt() shr 4
        )

        nbt.setInteger("dimension", dimension)
        nbt.setInteger("chunkX", chunkPos.first)
        nbt.setInteger("chunkZ", chunkPos.second)
        nbt.setInteger("compress", 0)

        synchronized(saveData) {
            saveData.values.forEach { it -> it.values.forEach { it.remove(name) } }
            val chunks = saveData.getOrPut(dimension) { HashMap() }
            val chunk = chunks.getOrPut(chunkPos) { HashMap() }
            chunk[name] = data
        }
    }

    fun loadNbt(host: MachineHost, nbt: NBTTagCompound, name: String): NBTTagCompound? {
        val data = loadBuffer(host, nbt, name)
        if (data.isEmpty())
            return null

        val bais = ByteArrayInputStream(data)
        val dis = DataInputStream(bais)
        return CompressedStreamTools.read(dis)
    }

    fun loadBuffer(host: MachineHost, nbt: NBTTagCompound, name: String): ByteArray {
        val dimension = nbt.getInteger("dimension")
        val cx = nbt.getInteger("chunkX")
        val cz = nbt.getInteger("chunkZ")
        val compress = nbt.getInteger("compress")
        val chunkPos = Pair(cx, cz)

        val data = saveData[dimension]?.get(chunkPos)?.get(name)
        if (data != null) return data

        val path = statePath
        val dimPath = File(path, dimension.toString())
        val chunkPath = File(dimPath, "${chunkPos.first}.${chunkPos.second}")
        val file = File(chunkPath, name)
        if (!file.exists())
            return ByteArray(0)

        return when (compress) {
            0 -> file.readBytes()
            else -> {
                TODO("compress unsupported")
            }
        }
    }

    @SubscribeEvent
    @Synchronized
    fun onChunkSave(e: ChunkDataEvent.Save) {
        val path = statePath
        val dimension = e.world.provider.dimension
        val chunkRawPos = e.chunk.pos
        val chunkPos = Pair(chunkRawPos.x, chunkRawPos.z)
        val dimPath = File(path, dimension.toString())
        val chunkPath = File(dimPath, "${chunkPos.first}.${chunkPos.second}")

        val chunks = saveData[dimension] ?: return
        val chunk = chunks[chunkPos] ?: return

        chunkPath.mkdirs()
        for ((name, data) in chunk) {
            val file = File(chunkPath, name)
            try {
                file.writeBytes(data)
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}