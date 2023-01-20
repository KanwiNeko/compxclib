package compxclib.functions

import compxclib.*
import compxclib.operators.plus
import kotlin.math.*

// complex logarithms
/**
 * Ln or Natural Logarithm of a [ComplexNumber]
 *
 * ln(z, n) is defined as `ln|z| + i(Arg(z) + 2πn)` where `n∈ℤ`
 * n is the **integer branch** of the natural logarithm
 * @param of that is a [ComplexNumber]
 * @param intBranch that is a [Int], default value is `0`
 * @return ln([ComplexNumber])
 * @since Version 1.0
 */
fun ln(of: ComplexNumber, intBranch: Int = 0): ComplexNumber {
    return ln(of.mag()) + i * (of.arg() + 2*PI*intBranch)
}

/**
 * Log or Logarithm of a [ComplexNumber]
 *
 * log(w, z) is defined as `ln(z, n) / ln(w, n)` where `n∈ℤ`
 * n is the **integer branch** of the natural logarithm
 * @param base that is the base of the **logarithm** and it's a [ComplexNumber]
 * @param of that is a [ComplexNumber]
 * @param intBranch that is a [Int], default value is `0`
 * @return log([ComplexNumber], [ComplexNumber], [Int])
 * @since Version 1.0
 * @see [ln]
 * @since Version 1.0
 */
fun log(base: ComplexNumber = ComplexNumber(10, 0), of: ComplexNumber, intBranch: Int = 0): ComplexNumber {
    return ln(of, intBranch) / ln(base, intBranch)
}

/**
 * Log or Logarithm of a [ComplexNumber]
 *
 * log(w, z) is defined as `ln(z, n) / ln(w, n)` where `n∈ℤ`
 * n is the **integer branch** of the natural logarithm
 * @param base that is the base of the **logarithm** and it's a [Number]
 * @param of that is a [ComplexNumber]
 * @param intBranch that is a [Int], default value is `0`
 * @return log([Number], [ComplexNumber], [Int])
 * @since Version 1.0
 * @see [ln]
 * @since Version 1.0
 */
@Suppress("unused")
fun log(base: Number = 10, of: ComplexNumber, intBranch: Int = 0): ComplexNumber {
    return log(base.toComplex(), of, intBranch)
}