package compxclib.functions

import compxclib.*
import kotlin.math.*

// complex logarithms
fun ln(of: CNumber, intBranch: Int = 0): CNumber {
    return ln(of.mag()) + (i * (of.arg() + 2*PI*intBranch))
}

fun log(base: CNumber, of: CNumber, intBranch: Int = 0): CNumber {
    return ln(of, intBranch) / ln(base, intBranch)
}

@Suppress("unused")
fun log(base: Number, of: CNumber, intBranch: Int = 0): CNumber {
    return log(base.toComplex(), of, intBranch)
}