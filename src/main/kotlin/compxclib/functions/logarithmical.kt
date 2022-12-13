package compxclib.functions

import compxclib.*

// complex logarithms
fun ln(of: CNumber): CNumber {
    return CNumber(kotlin.math.ln(of.magnitude), of.argument)
}

fun log(base: CNumber, of: CNumber): CNumber {
    return ln(of) / ln(base)
}

@Suppress("unused")
fun log(base: Number, of: CNumber): CNumber {
    return log(base.toComplex(), of)
}