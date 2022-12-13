package compxclib.functions

import compxclib.*
import kotlin.math.ln
import kotlin.math.roundToLong

// exponential functions
fun exp(of: CNumber): CNumber {
    return kotlin.math.exp(of.re()) * CNumber(kotlin.math.cos(of.im()).roundToLong(), kotlin.math.sin(of.im()).roundToLong())
}

@Suppress("unused")
fun CNumber.pow(to: CNumber): CNumber {
    return exp(to * ln(this))
}

fun CNumber.pow(to: Number): CNumber {
    return exp(to * ln(this))
}

@Suppress("unused")
fun Number.pow(to: CNumber): CNumber {
    return exp(ln(this.toDouble()) * to)
}

@Suppress("unused")
fun sqrt(of: CNumber): CNumber {
    return of.pow(1/2)
}

@Suppress("unused")
fun cbrt(of: CNumber): CNumber {
    return of.pow(1/3)
}

@Suppress("unused")
fun nthrt(of: CNumber, n: Number): CNumber {
    return of.pow(1/n.toDouble())
}