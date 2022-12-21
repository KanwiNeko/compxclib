package compxclib

import compxclib.functions.toComplex

//extension of operators with the Number class
operator fun Number.plus(complexNumber: ComplexNumber): ComplexNumber {
    return ComplexNumber(complexNumber.re() + this.toDouble(), complexNumber.im())
}

operator fun Number.minus(complexNumber: ComplexNumber): ComplexNumber {
    return ComplexNumber(this.toDouble() - complexNumber.re(), -1.0 * complexNumber.im())
}

operator fun Number.times(complexNumber: ComplexNumber): ComplexNumber {
    return complexNumber * this.toDouble()
}

operator fun Number.div(complexNumber: ComplexNumber): ComplexNumber {
    return this.toComplex() / complexNumber
}