package compxclib.functions

import compxclib.*
import kotlin.math.PI
import kotlin.math.ln

// complex logarithms
fun ln(of: CNumber, n: Int = 0): CNumber {

    return CNumber(ln(of.magnitude), of.argument + 2*PI*n)

}

fun log(base: CNumber, of: CNumber, n: Int = 0): CNumber {
    return ln(of, n) / ln(base, n)
}

@Suppress("unused")
fun log(base: Number, of: CNumber, n: Int = 0): CNumber {
    return log(base.toComplex(), of, n)
}