package compxclib.functions

import compxclib.*
import compxclib.enums.SqrtBranch
import compxclib.operators.div
import compxclib.operators.minus
import compxclib.operators.plus
import kotlin.math.PI

// trigonometric functions
/**
 * Sin of a [ComplexNumber]
 *
 * Defined using euler's formula
 * `sin(z) = -i(e^iz - e^-iz)/2`
 * @param of a [ComplexNumber]
 * @return [ComplexNumber] = `sin(z)`
 * @since Version 1.0
 * @see [exp]
 */
fun sin(of: ComplexNumber): ComplexNumber {
    return (-i/2) * (exp(i * of) - exp( -i * of))
}

/**
 * Cos of a [ComplexNumber]
 *
 * Defined using the trigonometric identity
 * `cos(z) = sin(z + π/2)`
 * @param of a [ComplexNumber]
 * @return [ComplexNumber] = `cos(z)`
 * @since Version 1.0
 * @see [sin]
 */
fun cos(of: ComplexNumber): ComplexNumber {
    return sin(of + PI/2)
}

/**
 * Tan of a [ComplexNumber]
 *
 * Defined using the trigonometric identity
 * `tan(z) = sin(z) / cos(z)`
 * @param of a [ComplexNumber]
 * @return [ComplexNumber] = `tan(z)`
 * @since Version 1.0
 * @see [sin]
 * @see [cos]
 */
fun tan(of: ComplexNumber): ComplexNumber {
    return sin(of) / cos(of)
}

/**
 * Cot of a [ComplexNumber]
 * Defined using the trigonometric identity
 * `cot(z) = cos(z) / sin(z)` or `cot(z) = 1 / tan(z)`
 * @param of a [ComplexNumber]
 * @return [ComplexNumber] = `cot(z)`
 * @since Version 1.0
 * @see [tan]
 * @see [sin]
 * @see [cos]
 */
fun cot(of: ComplexNumber): ComplexNumber {
    return cos(of) / sin(of)
}

/**
 * Sec of a [ComplexNumber]
 *
 * Defined using the trigonometric identity
 * `sec(z) = 1 / cos(z)`
 * @param of a [ComplexNumber]
 * @return [ComplexNumber] = `sec(z)`
 * @since Version 1.0
 * @see [cos]
 */
fun sec(of: ComplexNumber): ComplexNumber {
    return 1 / cos(of)
}

/**
 * Csc of a [ComplexNumber]
 *
 * Defined using the trigonometric identity
 * `csc(z) = 1 / sin(z)`
 * @param of a [ComplexNumber]
 * @return [ComplexNumber] = `csc(z)`
 * @since Version 1.0
 * @see [sin]
 */
fun csc(of : ComplexNumber): ComplexNumber {
    return 1 / sin(of)
}

//inverse trigonometric functions
/**
 * ArcSine of a [ComplexNumber]
 *
 * Defined by the formula
 * `arcsin(z, n) = -iln(iz +- sqrt(1 - z^2) + 2πn)` where `n∈ℤ`
 * @param of a [ComplexNumber]
 * @param sqrtBranch a [SqrtBranch]
 * @param intBranch a [Int]
 * @return [ComplexNumber] = `arcsin(z)`
 * @since Version 1.0
 * @see [ln]
 * @see [sqrtBranch]
 */
fun arcsin(of: ComplexNumber, sqrtBranch: SqrtBranch = SqrtBranch.POSITIVE, intBranch: Int = 0): ComplexNumber {
    return when(sqrtBranch) {
        SqrtBranch.POSITIVE -> -i * ln(i*of + sqrt(1 - of.pow(2))) + 2*PI*intBranch
        SqrtBranch.NEGATIVE -> -i * ln(i*of - sqrt(1 - of.pow(2))) + 2*PI*intBranch
    }
}

/**
 * ArcCosine of a [ComplexNumber]
 *
 * Defined by the formula
 * `arccos(z, n) = π/2 - arcsin(z, n)`
 * @param of a [ComplexNumber]
 * @param sqrtBranch a [SqrtBranch]
 * @param intBranch a [Int]
 * @return [ComplexNumber] = `arccos(z)`
 * @since Version 1.0
 * @see [ln]
 * @see [sqrtBranch]
 */
fun arccos(of: ComplexNumber, sqrtBranch: SqrtBranch = SqrtBranch.POSITIVE, intBranch: Int = 0): ComplexNumber {
    return PI/2 - arcsin(of, sqrtBranch, intBranch)
}

/**
 * ArcTangent of a [ComplexNumber]
 *
 * Defined by the formula
 * `arctan(z, n) = -i/2 ln( (1-z) / (1+z) , n)`
 * @param of a [ComplexNumber]
 * @param intBranch a [Int]
 * @return [ComplexNumber] = `arctan(z)`
 * @since Version 1.0
 * @see [ln]
 */
fun arctan(of: ComplexNumber, intBranch: Int = 0): ComplexNumber {
    return -i/2 * ln((1 - of) / (1 + of), intBranch)
}

/**
 * ArcCotangent of a [ComplexNumber]
 *
 * Defined by the formula
 * `arccot(z, n) = arctan(1/z, n)`
 * @param of a [ComplexNumber]
 * @param intBranch a [Int]
 * @return [ComplexNumber] = `arccot(z)`
 * @since Version 1.0
 * @see [arctan]
 */
fun arccot(of: ComplexNumber, intBranch: Int = 0): ComplexNumber {
    return arctan( 1 / of, intBranch)
}

/**
 * ArcSecant of a [ComplexNumber]
 *
 * Defined by the formula
 * `arcsec(z, n) = arccos(1/z, n)`
 * @param of a [ComplexNumber]
 * @param sqrtBranch a [SqrtBranch]
 * @param intBranch a [Int]
 * @return [ComplexNumber] = `arcsec(z)`
 * @since Version 1.0
 * @see [ln]
 * @see [sqrtBranch]
 * @see [arccos]
 */
fun arcsec(of: ComplexNumber, sqrtBranch: SqrtBranch = SqrtBranch.POSITIVE, intBranch: Int = 0): ComplexNumber {
    return arccos(1/of, sqrtBranch, intBranch)
}

/**
 * ArcCosecante of a [ComplexNumber]
 *
 * Defined by the formula
 * `arccsc(z, n) = arcsin(1/z, n)`
 * @param of a [ComplexNumber]
 * @param sqrtBranch a [SqrtBranch]
 * @param intBranch a [Int]
 * @return [ComplexNumber] = `arccsc(z)`
 * @since Version 1.0
 * @see [ln]
 * @see [sqrtBranch]
 * @see [arcsin]
 */
fun arccsc(of: ComplexNumber, sqrtBranch: SqrtBranch = SqrtBranch.POSITIVE, intBranch: Int = 0): ComplexNumber {
    return arcsin(1/of, sqrtBranch, intBranch)
}