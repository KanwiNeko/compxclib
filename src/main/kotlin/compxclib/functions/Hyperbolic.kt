package compxclib.functions

import compxclib.ComplexNumber
import compxclib.operators.div

// sinix = i*sinh(x)
// -i * sin(iz) = sinh(z)

/**
 * Sinh or Hyperbolic Sine of a [ComplexNumber]
 *
 * Sinh(z) is defined as `-i sin(iz)`
 * @param of that is a [ComplexNumber]
 * @return sinh([ComplexNumber])
 * @since Version 1.0
 */
@Suppress("unused")
fun sinh(of: ComplexNumber): ComplexNumber {
    return -i * sin(i * of)
}

/**
 * Cosh or Hyperbolic Cosine of a [ComplexNumber]
 *
 * Cosh(z) is defined as `cos(iz)`
 * @param of that is a [ComplexNumber]
 * @return cosh([ComplexNumber])
 * @since Version 1.0
 */
@Suppress("unused")
fun cosh(of: ComplexNumber): ComplexNumber {
    return cos(i * of)
}

/**
 * Tanh or Hyperbolic Tangent of a [ComplexNumber]
 *
 * Tanh(z) is defined as `sinh(z) / cosh(z)`
 * @param of that is a [ComplexNumber]
 * @return tanh([ComplexNumber])
 * @since Version 1.0
 */
@Suppress("unused")
fun tanh(of: ComplexNumber): ComplexNumber {
    return sinh(of) / cosh(of)
}

/**
 * Coth or Hyperbolic Cotangent of a [ComplexNumber]
 *
 * Coth(z) is defined as `cosh(z) / sinh(z)` or `1 / tanh(z)`
 * @param of that is a [ComplexNumber]
 * @return coth([ComplexNumber])
 * @since Version 1.0
 */
@Suppress("unused")
fun coth(of: ComplexNumber): ComplexNumber {
    return cos(of) / sin(of)
}

/**
 * Sech or Hyperbolic Secant of a [ComplexNumber]
 *
 * Sech(z) is defined as `1 / cosh(z)`
 * @param of that is a [ComplexNumber]
 * @return sech([ComplexNumber])
 * @since Version 1.0
 */
@Suppress("unused")
fun sech(of: ComplexNumber): ComplexNumber {
    return 1 / cosh(of)
}

/**
 * Csch or Hyperbolic Cosecante of a [ComplexNumber]
 *
 * Csch(z) is defined as `1 / sinh(z)`
 * @param of that is a [ComplexNumber]
 * @return csch([ComplexNumber])
 * @since Version 1.0
 */
@Suppress("unused")
fun csch(of: ComplexNumber): ComplexNumber {
    return 1 / sinh(of)
}