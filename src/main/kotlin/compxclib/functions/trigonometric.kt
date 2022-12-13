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
fun arcsin(of: CNumber, n: Int = 0): Array<CNumber> {
    val ap = -i*ln(i*of + sqrt(1 - of * of))
    val am = PI/2 + 2*PI*n +i*ln(i*of - sqrt(1 - of * of))
    return arrayOf(ap, am)
}

@Suppress("unused")
fun arccos(of: CNumber): CNumber {
    return 1/2 * (PI - 2 * arcsin(of)[0])
}

@Suppress("unused")
fun arctan(of: CNumber, n: Int = 0): CNumber {
    return 1/(2* i) * ln((1 - of) / (1 + of), n)
}

@Suppress("unused")
fun arccot(of: CNumber): CNumber {
    return arctan( 1 / of)
}

@Suppress("unused")
fun arcsec(of: CNumber): CNumber {
    return arccos(1/of)
}

@Suppress("unused")
fun arccsc(of: CNumber): CNumber {
    return arcsin(1/of)[0]
}