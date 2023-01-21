package compxclib.functions

import compxclib.ComplexNumber
import compxclib.operators.*

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

// ----------------------------------------------
// Inverse hyperbolic functions
// ----------------------------------------------

/**
 * arcsinh or Arc-Hyperbolic Sine of a [ComplexNumber].
 *
 * Arcsinh(z) is defined as ln(z + sqrt( z^2 - 1 ))
 * @param of, A [ComplexNumber]
 * @return arcsinh([ComplexNumber])
 * @since Version 1.0
 * @see sinh
 */
@Suppress("unused")
fun arcsinh(of: ComplexNumber): ComplexNumber {
    return ln(of + sqrt((of pow 2) + 1 ))
}

/**
 * arccosh or Arc-Hyperbolic Cosine of a [ComplexNumber].
 *
 * Arccosh(z) is defined as ln(z + sqrt( z^2 - 1 ))
 * @param of, A [ComplexNumber]
 * @return arccosh([ComplexNumber])
 * @since Version 1.0
 * @see cosh
 */
@Suppress("unused")
fun arccosh(of: ComplexNumber): ComplexNumber {
    return ln(of + sqrt((of pow 2) - 1 ))
}

/**
 * arctanH or Arc-Hyperbolic Tangent of a [ComplexNumber].
 *
 * Arctanh(z) is defined as 1/2 * ln( (1 + z) / (1 - z) )
 * @param of, A [ComplexNumber]
 * @return arctanh([ComplexNumber])
 * @since Version 1.0
 * @see tanh
 */
@Suppress("unused")
fun arctanh(of: ComplexNumber): ComplexNumber {
    return 0.5 * ln((1 + of) / (1 - of) )
}

/**
 * arccotH or Arc-Hyperbolic Cotangent of a [ComplexNumber].
 *
 * Arccoth(z) is defined as 1/2 * ln( (z + 1) / (z - 1) )
 * @param of, A [ComplexNumber]
 * @return arccosh([ComplexNumber])
 * @since Version 1.0
 * @see tanh
 */
@Suppress("unused")
fun arccoth(of: ComplexNumber): ComplexNumber {
    return 0.5 * ln((of + 1) / (of - 1) )
}

/**
 * arcsech or Arc-Hyperbolic Secant of a [ComplexNumber].
 *
 * Arcsech(z) is defined as ln( (1 + sqrt( 1 - z^2 )/z )
 * @param of, A [ComplexNumber]
 * @return arcsech([ComplexNumber])
 * @since Version 1.0
 * @see cosh
 */
@Suppress("unused")
fun arcsech(of: ComplexNumber): ComplexNumber {
    return arccosh(1/of)
}

/**
 * arccsch or Arc-Hyperbolic Cosecante of a [ComplexNumber].
 *
 * Arccsch(z) is defined as ln( (1 + sqrt( 1 + z^2 )/z )
 * @param of, A [ComplexNumber]
 * @return arccsch([ComplexNumber])
 * @since Version 1.0
 * @see cosh
 */
@Suppress("unused")
fun arccsch(of: ComplexNumber): ComplexNumber {
    return arcsinh(1/of)
}