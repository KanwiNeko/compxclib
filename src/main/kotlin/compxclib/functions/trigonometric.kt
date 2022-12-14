package compxclib.functions

import compxclib.*
import kotlin.math.PI

// trigonometric functions
@Suppress("unused")
fun sin(of: CNumber): CNumber {
    return (-i/2) * (exp(i * of) - exp( -i * of))
}

@Suppress("unused")
fun cos(of: CNumber): CNumber {
    return (1/2) * (exp(i * of) + exp( -i * of))
}

@Suppress("unused")
fun tan(of: CNumber): CNumber {
    return sin(of) / cos(of)
}

@Suppress("unused")
fun cot(of: CNumber): CNumber {
    return cos(of) / sin(of)
}

@Suppress("unused")
fun sec(of: CNumber): CNumber {
    return 1 / cos(of)
}

@Suppress("unused")
fun csc(of : CNumber): CNumber {
    return 1 / sin(of)
}

//inverse trigonometric functions
fun arcsin(of: CNumber, sqrtBranch: SqrtBranch = SqrtBranch.POSITIVE, intBranch: Int = 0): CNumber {
    return when(sqrtBranch) {
        SqrtBranch.POSITIVE -> -i * ln(i*of + sqrt(1 - of.pow(2))) + 2*PI*intBranch
        SqrtBranch.NEGATIVE -> -i * ln(i*of - sqrt(1 - of.pow(2))) + 2*PI*intBranch
    }
}

@Suppress("unused")
fun arccos(of: CNumber, sqrtBranch: SqrtBranch = SqrtBranch.POSITIVE, intBranch: Int = 0): CNumber {
    return PI/2 - arcsin(of, sqrtBranch, intBranch)
}

@Suppress("unused")
fun arctan(of: CNumber, intBranch: Int = 0): CNumber {
    return -i/2 * ln((1 - of) / (1 + of), intBranch)
}

@Suppress("unused")
fun arccot(of: CNumber, intBranch: Int = 0): CNumber {
    return arctan( 1 / of, intBranch)
}

@Suppress("unused")
fun arcsec(of: CNumber, sqrtBranch: SqrtBranch = SqrtBranch.POSITIVE, intBranch: Int = 0): CNumber {
    return arccos(1/of, sqrtBranch, intBranch)
}

@Suppress("unused")
fun arccsc(of: CNumber, sqrtBranch: SqrtBranch = SqrtBranch.POSITIVE, intBranch: Int = 0): CNumber {
    return arcsin(1/of, sqrtBranch, intBranch)
}