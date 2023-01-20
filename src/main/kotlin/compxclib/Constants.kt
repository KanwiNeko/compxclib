package compxclib

import compxclib.exceptions.ConversionRangeOutsideOfBounds

/**
 * Contains all constants used by the library
 * @property [i] the **i** constant (sqrt(-1))
 * @property [maxMethodNameSize]
 * @property [defaultRound] rounding floating points used by the [ComplexNumber.checkEquals] method
 * @since Version 1.0
 */
object Constants {


    private var defaultRound: Int = 13
    private val i = ComplexNumber(0, 1)
    private const val maxMethodNameSize = 10

    /**
     * Getter for the **i** constant
     *
     * @return a [ComplexNumber] with the value `0 + 1i`
     * @since Version 1.0
     */
    fun i(): ComplexNumber {
        return this.i
    }

    /**
     * Getter for the [maxMethodNameSize] constant
     * @return [maxMethodNameSize]
     * @since Version 1.0
     */
    fun getMaxMethodNameSize(): Int {
        return maxMethodNameSize
    }

    /**
     * Setter for the [defaultRound] constant
     *
     * This constant is used by [ComplexNumber.checkEquals] to round the properties of the
     * [ComplexNumber] in order to avoid accuracy problems
     * @since Version 1.0
     * @see [ComplexNumber]
     * @see [ComplexNumber.checkEquals]
     */
    @OptIn(ExperimentalStdlibApi::class)
    @Suppress("unused")
    fun setDefaultRound(value: Int) {
        if (value in 0..<16) {
            this.defaultRound = value
        } else {
            throw ConversionRangeOutsideOfBounds("The conversion number passed is outside the range")
        }
    }

    /**
     * Getter for the [defaultRound] constant
     *
     * This constant is used by [ComplexNumber.checkEquals] to round the properties of the
     * [ComplexNumber] in order to avoid accuracy problems
     * @return [defaultRound]
     * @since Version 1.0
     * @see [ComplexNumber]
     * @see [ComplexNumber.checkEquals]
     */
    fun getDefaultRound(): Int {
        return this.defaultRound
    }

}