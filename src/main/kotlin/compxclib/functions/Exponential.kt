package compxclib.functions

import compxclib.*
import compxclib.operators.times
import kotlin.math.cos
import kotlin.math.exp
import kotlin.math.sin

// exponential functions
fun exp(of: ComplexNumber): ComplexNumber {
    return exp(of.re()) * ComplexNumber(cos(of.im()), sin(of.im()))
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