package compxclib

//extension of operators with the Number class
operator fun Number.plus(cNumber: CNumber): CNumber {
    return CNumber(cNumber.re() + this.toDouble(), cNumber.im())
}

operator fun Number.minus(cNumber: CNumber): CNumber {
    return CNumber(this.toDouble() - cNumber.re(), -1.0 * cNumber.im())
}

operator fun Number.times(cNumber: CNumber): CNumber {
    return cNumber * this.toDouble()
}

operator fun Number.div(cNumber: CNumber): CNumber {
    return this.toComplex() / cNumber
}