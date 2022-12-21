package compxclib.functions

import compxclib.*
import kotlin.math.*

// complex logarithms
fun ln(of: ComplexNumber, intBranch: Int = 0): ComplexNumber {
    return ln(of.mag()) + (i * (of.arg() + 2*PI*intBranch))
}

fun log(base: ComplexNumber = ComplexNumber(10, 0), of: ComplexNumber, intBranch: Int = 0): ComplexNumber {
    return ln(of, intBranch) / ln(base, intBranch)
}

@Suppress("unused")
fun log(base: Number = 10, of: ComplexNumber, intBranch: Int = 0): ComplexNumber {
    return log(base.toComplex(), of, intBranch)
}