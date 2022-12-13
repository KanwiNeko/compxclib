package compxclib.functions

import compxclib.CNumber
import compxclib.div

// sinix = i*sinh(x)
// -i * sin(iz) = sinh(z)

@Suppress("unused")
fun sinh(of: CNumber): CNumber {
    return -i * sin(i * of)
}

@Suppress("unused")
fun cosh(of: CNumber): CNumber {
    return cos(i * of)
}

@Suppress("unused")
fun tanh(of: CNumber): CNumber {
    return sinh(of) / cosh(of)
}

@Suppress("unused")
fun coth(of: CNumber): CNumber {
    return 1 / tanh(of)
}

@Suppress("unused")
fun sech(of: CNumber): CNumber {
    return 1 / cosh(of)
}

@Suppress("unused")
fun csch(of: CNumber): CNumber {
    return 1 / sinh(of)
}