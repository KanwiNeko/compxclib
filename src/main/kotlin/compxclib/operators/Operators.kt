package compxclib.operators

import compxclib.ComplexNumber
import compxclib.functions.exp
import compxclib.functions.toComplex
import kotlin.math.ln

//extension of operators with the Number class
/**
 * Extension of the `+` operator to include [ComplexNumber]
 * @param [complexNumber] a [ComplexNumber]
 * @return [ComplexNumber] result of adding a [Number] and a [ComplexNumber]
 * @since Version 1.0
 * @see [Number]
 * @see [ComplexNumber]
 */
operator fun Number.plus(complexNumber: ComplexNumber): ComplexNumber {
    return ComplexNumber(complexNumber.re + this.toDouble(), complexNumber.im)
}

/**
 * Extension of the `-` operator to include [ComplexNumber]
 * @param [complexNumber] a [ComplexNumber]
 * @return [ComplexNumber] result of subtracting a [Number] and a [ComplexNumber]
 * @since Version 1.0
 * @see [Number]
 * @see [ComplexNumber]
 */
operator fun Number.minus(complexNumber: ComplexNumber): ComplexNumber {
    return ComplexNumber(this.toDouble() - complexNumber.re, -1.0 * complexNumber.im)
}

/**
 * Extension of the `*` operator to include [ComplexNumber]
 * @param [complexNumber] a [ComplexNumber]
 * @return [ComplexNumber] result of multiplying a [Number] and a [ComplexNumber]
 * @since Version 1.0
 * @see [Number]
 * @see [ComplexNumber]
 */
operator fun Number.times(complexNumber: ComplexNumber): ComplexNumber {
    return complexNumber * this
}

/**
 * Extension of the `/` operator to include [ComplexNumber]
 * @param [complexNumber] a [ComplexNumber]
 * @return [ComplexNumber] result of diving a [Number] and a [ComplexNumber]
 * @since Version 1.0
 * @see [Number]
 * @see [ComplexNumber]
 */
operator fun Number.div(complexNumber: ComplexNumber): ComplexNumber {
    return this.toComplex() / complexNumber
}

/**
 * Extension of the `%` operator to include [ComplexNumber]
 *
 * @param ComplexNumber a [ComplexNumber]
 * @return [ComplexNumber] result of the modulo between a [Number] and a
 *     [ComplexNumber]
 * @see [Number]
 * @see [ComplexNumber]
 * @since Version 1.0
 */
operator fun Number.rem(complexNumber: ComplexNumber): ComplexNumber {
    return this.toComplex() % complexNumber
}

/**
 * Infix operator pow to extend [Number] pow [ComplexNumber]
 * @param [complexNumber] a [ComplexNumber]
 * @return [ComplexNumber] result of the power between a [Number] and a [ComplexNumber]
 * @since Version 1.0
 * @see [Number]
 * @see [ComplexNumber]
 */
@Suppress("unused")
infix fun Number.pow(to: ComplexNumber): ComplexNumber {
    return exp(ln(this.toDouble()) * to)
}

// Extension for a number
/**
 * `i` extension property for numbers that return an imaginary number
 * @since Version 1.2
 */
@Suppress("unused")
val Number.i: ComplexNumber
    get() = ComplexNumber(0, this)