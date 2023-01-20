package compxclib.functions

import compxclib.ComplexNumber
import compxclib.operators.div

// sinix = i*sinh(x)
// -i * sin(iz) = sinh(z)

@Suppress("unused")
fun sinh(of: ComplexNumber): ComplexNumber {
    return -i * sin(i * of)
}

@Suppress("unused")
fun cosh(of: ComplexNumber): ComplexNumber {
    return cos(i * of)
}

@Suppress("unused")
fun tanh(of: ComplexNumber): ComplexNumber {
    return sinh(of) / cosh(of)
}

@Suppress("unused")
fun coth(of: ComplexNumber): ComplexNumber {
    return 1 / tanh(of)
}

@Suppress("unused")
fun sech(of: ComplexNumber): ComplexNumber {
    return 1 / cosh(of)
}

@Suppress("unused")
fun csch(of: ComplexNumber): ComplexNumber {
    return 1 / sinh(of)
}