package compxclib.functions

import compxclib.*
import kotlin.math.ln
import kotlin.math.roundToLong

// exponential functions
fun exp(of: ComplexNumber): ComplexNumber {
    return kotlin.math.exp(of.re()) * ComplexNumber(kotlin.math.cos(of.im()).roundToLong(), kotlin.math.sin(of.im()).roundToLong())
}

@Suppress("unused")
fun ComplexNumber.pow(to: ComplexNumber): ComplexNumber {
    return exp(to * ln(this))
}

fun ComplexNumber.pow(to: Number): ComplexNumber {
    return exp(to * ln(this))
}

@Suppress("unused")
fun Number.pow(to: ComplexNumber): ComplexNumber {
    return exp(ln(this.toDouble()) * to)
}

@Suppress("unused")
fun sqrt(of: ComplexNumber): ComplexNumber {
    return of.pow(0.5)
}

@Suppress("unused")
fun cbrt(of: ComplexNumber): ComplexNumber {
    return of.pow(1/3)
}

@Suppress("unused")
fun nthrt(of: ComplexNumber, n: Number): ComplexNumber {
    return of.pow(1/n.toDouble())
}