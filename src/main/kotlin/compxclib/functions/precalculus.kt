package compxclib.functions

import compxclib.CNumber
import compxclib.Constants
import kotlin.math.*

fun floor(of: CNumber): CNumber {
    return CNumber(floor(of.re()), floor(of.im()))
}

fun ceil(of: CNumber): CNumber {
    return CNumber(ceil(of.re()), ceil(of.im()))
}