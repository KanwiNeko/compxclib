package compxclib.functions

import compxclib.*
import kotlin.math.PI

// trigonometric functions
@Suppress("unused")
fun sin(of: CNumber): CNumber {
    return (1/2) * (exp(i * of) - exp( -i * of))
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
fun arcsin(of: CNumber): CNumber {
    return -i * ln(i * of + sqrt(1 - of.pow(2)))
}

@Suppress("unused")
fun arccos(of: CNumber): CNumber {
    return 1/2 * (PI - 2* arcsin(of))
}

@Suppress("unused")
fun arctan(of: CNumber): CNumber {
    return 1/(2* i) * ln((1 - of) / (1 + of))
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
    return arcsin(1/of)
}