package kr.pe.ecmaxp.openpie

import li.cil.oc.api.FileSystem
import li.cil.oc.api.Network
import li.cil.oc.api.machine.Context
import li.cil.oc.api.network.ManagedEnvironment
import li.cil.oc.api.network.Node
import li.cil.oc.api.network.Visibility
import li.cil.oc.api.prefab.TileEntityEnvironment


class OpenPieFSTile : TileEntityEnvironment() {
    private var fileSystem: ManagedEnvironment

    init {
        node = Network.newNode(this, Visibility.Network).create()
        fileSystem = FileSystem.asManagedEnvironment(
                FileSystem.fromClass(this.javaClass, OpenPie.MODID, "opos"),
                "OpenPie Debug FileSystem",
                null,
                null,
                5
        )
    }

    override fun onConnect(node: Node) {
        if (node.host() is Context) {
            node.connect(fileSystem.node())
        }
    }

    override fun onDisconnect(node: Node) {
        if (node.host() is Context) {
            node.disconnect(fileSystem.node())
        } else if (node === this.node) {
            fileSystem.node().remove()
        }
    }
}