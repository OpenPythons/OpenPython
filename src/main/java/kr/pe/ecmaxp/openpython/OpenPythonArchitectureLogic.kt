package kr.pe.ecmaxp.openpython

import kr.pe.ecmaxp.openpython.arch.OpenPythonFirmware
import li.cil.oc.api.machine.Machine

interface OpenPythonArchitectureLogic {
    val LATEST_FIRMWARE: OpenPythonFirmware
    fun spawn(machine: Machine, memorySize: Int): OpenPythonVirtualMachine
}
