package compxclib.operators

import compxclib.ComplexNumber
import compxclib.functions.exp
import compxclib.functions.toComplex
import kotlin.math.ln

//extension of operators with the Number class
operator fun Number.plus(complexNumber: ComplexNumber): ComplexNumber {
    return ComplexNumber(complexNumber.re() + this.toDouble(), complexNumber.im())
}

operator fun Number.minus(complexNumber: ComplexNumber): ComplexNumber {
    return ComplexNumber(this.toDouble() - complexNumber.re(), -1.0 * complexNumber.im())
}

operator fun Number.times(complexNumber: ComplexNumber): ComplexNumber {
    return complexNumber * this
}

operator fun Number.div(complexNumber: ComplexNumber): ComplexNumber {
    return this.toComplex() / complexNumber
}

@Suppress("unused")
infix fun Number.pow(to: ComplexNumber): ComplexNumber {
    return exp(ln(this.toDouble()) * to)
}