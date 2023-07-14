package compxclib.functions

import compxclib.ComplexNumber
import kotlin.math.ceil
import kotlin.math.floor

/**
 * calls the `floor()` function on both parameters of the complex number.
 *
 * @return [ComplexNumber] = `floor(real) + i floor(imaginary)`
 * @since Version 1.0
 */
fun floor(of: ComplexNumber): ComplexNumber {
    return ComplexNumber(floor(of.re), floor(of.im))
}

/**
 * calls the `ceil()` function on both parameters of the complex number.
 * @return [ComplexNumber] = `ceil(real) + i ceil(imaginary)`
 * @since Version 1.0
 */
fun ceil(of: ComplexNumber): ComplexNumber {
    return ComplexNumber(ceil(of.re), ceil(of.im))
}