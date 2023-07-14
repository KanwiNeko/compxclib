package compxclib.functions

import compxclib.ComplexNumber
import compxclib.operators.div
import compxclib.operators.times
import kotlin.math.cos
import kotlin.math.exp
import kotlin.math.sin

// exponential functions
/**
 * Exp of a [ComplexNumber]
 *
 * exp(z) or e^z is defined used euler's formula
 * `e^(a+bi) = e^a * (cos(b) + isin(b))`
 * @param of that is a [ComplexNumber]
 * @return exp([ComplexNumber])
 * @since Version 1.0
 */
fun exp(of: ComplexNumber): ComplexNumber {
    return exp(of.re) * ComplexNumber(cos(of.im), sin(of.im))
}

/**
 * Sqrt or Square Root of a [ComplexNumber]
 *
 * sqrt(z) is defined as `z pow 0.5`
 * @param of that is a [ComplexNumber]
 * @return sqrt([ComplexNumber])
 * @since Version 1.0
 */
@Suppress("unused")
fun sqrt(of: ComplexNumber): ComplexNumber {
    return of pow 0.5
}

/**
 * Cbrt or Cubic Root of a [ComplexNumber]
 *
 * cbrt(z) is defined as `z pow 0.333...`
 * @param of that is a [ComplexNumber]
 * @return cbrt([ComplexNumber])
 * @since Version 1.0
 */
@Suppress("unused")
fun cbrt(of: ComplexNumber): ComplexNumber {
    return of pow 1/3
}

/**
 * Nthrt or Nth Root of a [ComplexNumber]
 *
 * nthrt(z) is defined as `z pow 1/n`
 * @param of that is a [ComplexNumber]
 * @param n that is a [Number]
 * @return nthrt([ComplexNumber])
 * @since Version 1.0
 */
@Suppress("unused")
fun nthrt(of: ComplexNumber, n: Number): ComplexNumber {
    return of pow 1/n.toDouble()
}

/**
 * Nthrt or Nth Root of a [ComplexNumber]
 *
 * nthrt(z, n) is defined as `z pow 1/n`
 * @param of that is a [ComplexNumber]
 * @param n that is a [ComplexNumber]
 * @return nthrt([ComplexNumber])
 * @since Version 1.0
 */
@Suppress("unused")
fun nthrt(of: ComplexNumber, n: ComplexNumber): ComplexNumber {
    return of pow 1/n
}