@file:Suppress("unused")

package kr.pe.ecmaxp.optvm

class ECPU {
    init {
        System.loadLibrary("optvm")
        init()
    };

    external fun init()
    external fun step(): IntArray
    external fun debug(address: Int)
}