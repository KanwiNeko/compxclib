package compxclib.functions

import compxclib.ComplexNumber
import kotlin.math.*

fun floor(of: ComplexNumber): ComplexNumber {
    return ComplexNumber(floor(of.re()), floor(of.im()))
}

fun ceil(of: ComplexNumber): ComplexNumber {
    return ComplexNumber(ceil(of.re()), ceil(of.im()))
}