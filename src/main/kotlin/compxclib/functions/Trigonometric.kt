package compxclib.functions

import compxclib.*
import kotlin.math.PI

// trigonometric functions
@Suppress("unused")
fun sin(of: ComplexNumber): ComplexNumber {
    return (-i/2) * (exp(i * of) - exp( -i * of))
}

@Suppress("unused")
fun cos(of: ComplexNumber): ComplexNumber {
    return sin(of + PI/2)
}

@Suppress("unused")
fun tan(of: ComplexNumber): ComplexNumber {
    return sin(of) / cos(of)
}

@Suppress("unused")
fun cot(of: ComplexNumber): ComplexNumber {
    return cos(of) / sin(of)
}

@Suppress("unused")
fun sec(of: ComplexNumber): ComplexNumber {
    return 1 / cos(of)
}

@Suppress("unused")
fun csc(of : ComplexNumber): ComplexNumber {
    return 1 / sin(of)
}

//inverse trigonometric functions
fun arcsin(of: ComplexNumber, sqrtBranch: SqrtBranch = SqrtBranch.POSITIVE, intBranch: Int = 0): ComplexNumber {
    return when(sqrtBranch) {
        SqrtBranch.POSITIVE -> -i * ln(i*of + sqrt(1 - of.pow(2))) + 2*PI*intBranch
        SqrtBranch.NEGATIVE -> -i * ln(i*of - sqrt(1 - of.pow(2))) + 2*PI*intBranch
    }
}

@Suppress("unused")
fun arccos(of: ComplexNumber, sqrtBranch: SqrtBranch = SqrtBranch.POSITIVE, intBranch: Int = 0): ComplexNumber {
    return PI/2 - arcsin(of, sqrtBranch, intBranch)
}

@Suppress("unused")
fun arctan(of: ComplexNumber, intBranch: Int = 0): ComplexNumber {
    return -i/2 * ln((1 - of) / (1 + of), intBranch)
}

@Suppress("unused")
fun arccot(of: ComplexNumber, intBranch: Int = 0): ComplexNumber {
    return arctan( 1 / of, intBranch)
}

@Suppress("unused")
fun arcsec(of: ComplexNumber, sqrtBranch: SqrtBranch = SqrtBranch.POSITIVE, intBranch: Int = 0): ComplexNumber {
    return arccos(1/of, sqrtBranch, intBranch)
}

@Suppress("unused")
fun arccsc(of: ComplexNumber, sqrtBranch: SqrtBranch = SqrtBranch.POSITIVE, intBranch: Int = 0): ComplexNumber {
    return arcsin(1/of, sqrtBranch, intBranch)
}