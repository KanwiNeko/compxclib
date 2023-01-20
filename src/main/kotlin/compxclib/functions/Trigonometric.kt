package compxclib.functions

import compxclib.*
import compxclib.enums.SqrtBranch
import compxclib.operators.div
import compxclib.operators.minus
import compxclib.operators.plus
import kotlin.math.PI

// trigonometric functions
fun sin(of: ComplexNumber): ComplexNumber {
    return (-i/2) * (exp(i * of) - exp( -i * of))
}

fun cos(of: ComplexNumber): ComplexNumber {
    return sin(of + PI/2)
}

fun tan(of: ComplexNumber): ComplexNumber {
    return sin(of) / cos(of)
}

fun cot(of: ComplexNumber): ComplexNumber {
    return cos(of) / sin(of)
}

fun sec(of: ComplexNumber): ComplexNumber {
    return 1 / cos(of)
}

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

fun arccos(of: ComplexNumber, sqrtBranch: SqrtBranch = SqrtBranch.POSITIVE, intBranch: Int = 0): ComplexNumber {
    return PI/2 - arcsin(of, sqrtBranch, intBranch)
}

fun arctan(of: ComplexNumber, intBranch: Int = 0): ComplexNumber {
    return -i/2 * ln((1 - of) / (1 + of), intBranch)
}

fun arccot(of: ComplexNumber, intBranch: Int = 0): ComplexNumber {
    return arctan( 1 / of, intBranch)
}

fun arcsec(of: ComplexNumber, sqrtBranch: SqrtBranch = SqrtBranch.POSITIVE, intBranch: Int = 0): ComplexNumber {
    return arccos(1/of, sqrtBranch, intBranch)
}

fun arccsc(of: ComplexNumber, sqrtBranch: SqrtBranch = SqrtBranch.POSITIVE, intBranch: Int = 0): ComplexNumber {
    return arcsin(1/of, sqrtBranch, intBranch)
}