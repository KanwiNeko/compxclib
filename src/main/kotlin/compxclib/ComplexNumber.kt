@file:Suppress("MemberVisibilityCanBePrivate", "unused")

package compxclib

import compxclib.enums.Parameter
import compxclib.exceptions.IllegalConversionArgument
import compxclib.exceptions.InvalidComparison
import compxclib.functions.*
import compxclib.operators.times
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.*

/**
 * Main *Complex Number* class.
 *
 * @param real Real value of this complex number as a [Number].
 * @param imaginary Imaginary value of this complex number as a [Number].
 * @constructor Creates a complex number.
 * @property[re] Real value of the complex number.
 * @property[im] Imaginary value of this complex number.
 * @property[mag] Modulus of this complex number.
 * @property[arg] Argument of this complex number.
 * @property[mod] Alias of [mag].
 * @since Version 1.0
 */
data class ComplexNumber(private val real: Number, private val imaginary: Number) {
    // -------------------------------------------------------------
    // Setting main fields of the class
    // -------------------------------------------------------------
    /**
     * Actual *real* value of the number. Converts [Number] to [Double]
     *
     * @since Version 1.0
     */
    val re = real.toDouble()

    /**
     * Actual *imaginary* value of the number. Converts [Number] to [Double]
     *
     * @since Version 1.0
     */
    val im = imaginary.toDouble()

    /**
     * *Modulus* or *Magnitude* of the complex number
     *
     * @since Version 1.0
     */
    val mag: Double by lazy { mag(this) }

    /**
     * *Modulus* or *Magnitude* of the complex number
     *
     * alias for the [ComplexNumber.mag] field
     *
     * @since Version 1.1
     */
    val mod: Double
        get() = mag

    /**
     * *Argument* of the complex number
     *
     * @since Version 1.0
     */
    val arg: Double by lazy { arg(this) }

    /**
     * @return A new complex number that is the conjugate of this
     *     [ComplexNumber]
     * @since Version 1.0
     */
    fun conjugate(): ComplexNumber {
        return ComplexNumber(re, -1 * im)
    }

    /**
     * Converts a [ComplexNumber] to a real [Double]
     *
     * @return Returns a Double containing the real value of a complex number
     * @throws IllegalConversionArgument when [im] isn't **0**
     * @since Version 1.0
     */
    @Throws(IllegalConversionArgument::class)
    fun toReal(): Double {
        return if (this.imaginary != 0) this.re
        else throw IllegalConversionArgument("This number has a non zero imaginary part.")
    }
    // -------------------------------------------------------------
    // definition of operators
    // -------------------------------------------------------------

    // binary operators between complex numbers
    /**
     * Adds two complex numbers together.
     * It's an operator overload of [ComplexNumber]
     *
     * @return Addition between two instances of [ComplexNumber]
     * @since Version 1.0
     */
    operator fun plus(b: ComplexNumber): ComplexNumber{
        return ComplexNumber(re + b.re,
            im + b.im)
    }

    /**
     * Subtracts one complex number from another.
     * It's an operator overload of [ComplexNumber]
     *
     * @return Subtraction between two instances of [ComplexNumber]
     * @since Version 1.0
     */
    operator fun minus(b: ComplexNumber): ComplexNumber{
        return ComplexNumber(this.re - b.re,
            this.im - b.im)
    }

    /**
     * Multiplies one complex number with another
     * It's an operator overload of [ComplexNumber]
     *
     * @return Multiplication between two instances of [ComplexNumber]
     * @since Version 1.0
     */
    operator fun times(b: ComplexNumber): ComplexNumber {
        return ComplexNumber(this.re * b.re - this.im * b.im,
            this.re * b.im + this.im * b.re )
    }

    /**
     * Divides one complex number with another complex number.
     * It's an operator overload of [ComplexNumber]
     * @return Division between two instances of [ComplexNumber]
     * @since Version 1.0
     */
    operator fun div(b: ComplexNumber): ComplexNumber{
        val wwc = 1/(b * b.conjugate()).toReal()
        val zwc = this * b.conjugate()
        return zwc * wwc
    }

    /**
     * Remainder of the division between two [ComplexNumber].
     * It's an operator overload of [ComplexNumber]
     * @return Modulo between two instances of [ComplexNumber]
     * @since Version 1.0
     */
    operator fun rem(b: ComplexNumber): ComplexNumber {
        return -b * floor(this / b) + this.re + i * this.im
    }

    // binary operators between a real number and a complex number
    /**
     * Addition between a [Number] and a [ComplexNumber].
     * Overloads **plus()** to include [ComplexNumber]
     * @return The result of adding a [Number] and a [ComplexNumber]
     * @since Version 1.0
     */
    operator fun plus(b: Number): ComplexNumber{
        return ComplexNumber(this.re + b.toDouble(),
            this.im)
    }

    /**
     * Subtraction between a [Number] and a [ComplexNumber].
     * Overloads **minus()** to include [ComplexNumber]
     * @return The result of subtracting a [Number] and a [ComplexNumber]
     * @since Version 1.0
     */
    operator fun minus(b: Number): ComplexNumber{
        return ComplexNumber(this.re - b.toDouble(),
            this.im)
    }

    /**
     * Multiplication between a [Number] and a [ComplexNumber].
     * Overloads **times()** to include [ComplexNumber]
     * @return The result of multiplying a [Number] and a [ComplexNumber]
     * @since Version 1.0
     */
    operator fun times(b: Number): ComplexNumber{
        return ComplexNumber(this.re * b.toDouble(),
            this.im * b.toDouble())
    }

    /**
     * Division between a [Number] and a [ComplexNumber].
     * Overloads **div()** to include [ComplexNumber]
     * @return The result of dividing a [Number] and a [ComplexNumber]
     * @since Version 1.0
     */
    operator fun div(b: Number): ComplexNumber{
        return this / b.toComplex()
    }

    //Increments and Decrements
    /**
     * Increments by **1** the values of [re] and [im]
     * It's an operator overload of [ComplexNumber]
     *
     * Using it as a function call and not an operator lets you use the [parameter] parameter, this
     * is an Enum type [Parameter] that lets you choose which component of the [ComplexNumber] to increment
     *
     * @return The result of adding 1 to the [re] and [im] fields of a [ComplexNumber]
     * @since Version 1.0
     * @see Parameter
     */
    operator fun inc(parameter: Parameter = Parameter.BOTH): ComplexNumber {
        return when(parameter) {
            Parameter.REAL -> ComplexNumber(re + 1, im)
            Parameter.IMAGINARY -> ComplexNumber(re, im + 1)
            else -> ComplexNumber(re + 1, im + 1)
        }
    }

    /**
     * Decreases by **1** the values of [re] and [im]
     * It's an operator overload of [ComplexNumber]
     *
     * Using it as a function call and not an operator lets you use the [parameter] parameter, this
     * is an Enum type [Parameter] that lets you choose which component of the [ComplexNumber] to decrease
     *
     * @return The result of subtracting 1 to the [re] and [im] fields of a [ComplexNumber]
     * @since Version 1.0
     * @see Parameter
     */
    operator fun dec(parameter: Parameter = Parameter.BOTH): ComplexNumber {
        return when(parameter) {
            Parameter.REAL -> ComplexNumber(re - 1, im)
            Parameter.IMAGINARY -> ComplexNumber(re, im - 1)
            else -> ComplexNumber(re - 1, im - 1)
        }
    }

    //other operators
    /**
     * Multiplies both [re] and [im] components of this [ComplexNumber] by -1.
     * It's an operator overload of [ComplexNumber]
     * @return The negative version of a [ComplexNumber]
     * @since Version 1.0
     */
    operator fun unaryMinus(): ComplexNumber{
        return ComplexNumber(-1 *  re, -1 * im)
    }

    /**
     * Compares the values of two Complex Numbers by using the [checkEquals] member function of
     * [ComplexNumber].
     * It's an operator overload of [ComplexNumber]
     * @see checkEquals
     * @return the result of a value comparison between 2 instances of [ComplexNumber]
     * @since Version 1.0
     */
    override operator fun equals(other: Any?): Boolean {
        return when (other) {
            is ComplexNumber -> checkEquals(other)
            is Number -> checkEquals(other.toComplex())
            else -> throw InvalidComparison("Cannot compare ComplexNumber to $other")
        }
    }

    // -------------------------------------------------------------
    // defining power operators
    // -------------------------------------------------------------

    /**
     * Performs the operation **Z ^ W**
     *
     * Can be used as an infix function in kotlin as:
     * [ComplexNumber] pow [ComplexNumber]
     * @return [ComplexNumber] result of the `power` operation
     * @since Version 1.0
     */
    infix fun pow(other: ComplexNumber): ComplexNumber {
        return exp(other * ln(this))
    }

    /**
     * Performs the operation **Z ^ W**
     *
     * Can be used as an infix function in kotlin as:
     * [ComplexNumber] pow [Number]
     * @return [ComplexNumber] result of the `power` operation
     * @since Version 1.0
     */
    infix fun pow(other: Number): ComplexNumber {
        return exp(other * ln(this))
    }

    // -------------------------------------------------------------
    //overriding Any class methods
    // -------------------------------------------------------------
    /**
     * Converts the [ComplexNumber] class to a string
     *
     * makes a simple check to determine whether both member fields ([re] and [im]) are
     * integers to convert Complex Numbers to the form **a + bi**
     * @see [Any.toString]
     * @return A string representation of [ComplexNumber]
     * @since Version 1.0
     */
    override fun toString(): String {

        val a = when(sign(im)) {
            -1.0 -> "-"
            else -> "+"
        }

        return if (floor(re) == ceil(re) && floor(im) == ceil(im)) {
            re.roundToInt().toString() + " $a " + abs(im).roundToInt().toString() + "i"
        } else
            re.toString() + " $a " + abs(im).toString() + "i"
    }

    /**
     * Converts the [ComplexNumber] class to a hashCode
     *
     * @see [Any.hashCode]
     * @return A hashCode representation of [ComplexNumber]
     * @since Version 1.0
     */
    override fun hashCode(): Int {

        var result = re.hashCode()
        result = 31 * result + im.hashCode()
        return result
    }
    // -------------------------------------------------------------
    // Other methods
    // -------------------------------------------------------------
    /**
     * Rounds the values of the complex number to make a less precise comparison
     *
     * Using the library's functions will inevitably end on inaccuracies since the size of a
     * [Double] is only **8** bytes long, the last 2 or 3 decimals will most often change compared to
     * their real value. The value of [Constants.getDefaultRound] will be used to round up the elements
     * of the complex number and compare that rounded up version.
     * @return boolean of compared [ComplexNumber] instances.
     * @since Version 1.0
     * @see [Constants]
     * @see [Double]
     */
    private fun checkEquals(b: ComplexNumber): Boolean {
        val roundTo = Constants.getDefaultRound()
        val thisNumber = this.round(roundTo)
        val otherNumber = b.round(roundTo)

        val reals = thisNumber.re == otherNumber.re
        val imaginaries = thisNumber.im == otherNumber.im

        return reals && imaginaries
    }

    /**
     * rounds a [ComplexNumber] to [places] decimal places by rounding both the
     * [re] and [im] members
     *
     * @param places
     * @return A rounded [ComplexNumber]
     * @see BigDecimal.setScale
     * @since Version 1.0
     */
    fun round(places: Int): ComplexNumber {
        val reRounded = BigDecimal(this.re).setScale(places, RoundingMode.FLOOR)
        val imRounded = BigDecimal(this.im).setScale(places, RoundingMode.FLOOR)
        return ComplexNumber(reRounded, imRounded)
    }

    /**
     * Rounds both [re] and [im] members of a [ComplexNumber] to an [Int]
     *
     * @return [ComplexNumber] with [Int] members
     * @since Version 1.0
     */
    fun roundToGaussianInteger(): ComplexNumber {
        return this.round(0)
    }

    /**
     * Will perform a modular operation between the current complex number and
     * a parameter [parameter] and will return `true` or `false` depending on
     * the result of said operation
     *
     * @param parameter
     * @return A boolean with the result of [parameter] % [ComplexNumber] == 0
     * @see rem
     * @since Version 1.0
     */
    @Suppress("unused")
    fun divides(parameter: ComplexNumber): Boolean {
        return parameter % this == 0.0.toComplex()
    }

    // Deprecated getters
    @Deprecated("Use property access instead", ReplaceWith("re"))
    fun re(): Double = this.re

    @Deprecated("Use property access instead", ReplaceWith("im"))
    fun im(): Double = this.im

    @Deprecated("Use property access instead", ReplaceWith("mag"))
    fun mag(): Double = this.mag

    @Deprecated("Use property access instead", ReplaceWith("arg"))
    fun arg(): Double = this.arg
}
