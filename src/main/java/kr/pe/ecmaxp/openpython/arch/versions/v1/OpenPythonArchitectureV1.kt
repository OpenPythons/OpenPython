package kr.pe.ecmaxp.openpython.arch.versions.v1

import kr.pe.ecmaxp.openpython.OpenPythonArchitectureLogic
import kr.pe.ecmaxp.openpython.OpenPythonVirtualMachine
import kr.pe.ecmaxp.openpython.arch.OpenPythonArchitecture
import kr.pe.ecmaxp.openpython.arch.OpenPythonFirmware
import li.cil.oc.api.machine.Architecture
import li.cil.oc.api.machine.Machine


@Suppress("unused", "ClassName")
@Architecture.Name("OpenPython v1.0")
class OpenPythonArchitectureV1(machine: Machine) : OpenPythonArchitecture(machine, this) {
    companion object : OpenPythonArchitectureLogic {
        val FIRMWARE_v1_0_1: OpenPythonFirmware = OpenPythonFirmware("v1.0.1")
        val FIRMWARE_v1_0_2: OpenPythonFirmware = OpenPythonFirmware("v1.0.2")
        override val LATEST_FIRMWARE: OpenPythonFirmware = FIRMWARE_v1_0_2

        override fun spawn(machine: Machine, memorySize: Int): OpenPythonVirtualMachine {
            return OpenPythonVirtualMachineV1(machine, memorySize)
        }
    }
}
