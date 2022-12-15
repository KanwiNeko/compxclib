package compxclib

import compxclib.functions.*
import kotlin.jvm.Throws
import kotlin.math.*
import kotlin.Any as Any
import java.math.BigDecimal
import java.math.RoundingMode

//Main complex class
data class CNumber(private val real: Number,private val imaginary: Number){
    // -------------------------------------------------------------
    // Setting main fields of the class
    // -------------------------------------------------------------
    private val re = real.toDouble()
    private val im = imaginary.toDouble()
    private var mag: Double? = null
    private var arg: Double? = null

    // -------------------------------------------------------------
    // main methods of the class
    // -------------------------------------------------------------
    @SuppressWarnings
    fun conjugate(): CNumber {
        return CNumber(re, -1 * im)
    }

    @Throws(IllegalConversionArgument::class)
    fun toReal(): Double {
        if (this.im == 0.0) {
            return this.re
        } else {
            throw IllegalConversionArgument("This number has a non zero imaginary part.")
        }
    }

    // -------------------------------------------------------------
    // definition of operators
    // -------------------------------------------------------------

    // binary operators between complex numbers
    operator fun plus(b: CNumber): CNumber{
        return CNumber(re + b.re,
            im + b.im)
    }

    operator fun minus(b: CNumber): CNumber{
        return CNumber(this.re - b.re,
            this.im - b.im)
    }

    operator fun times(b: CNumber): CNumber {
        return CNumber(this.re * b.re - this.im * b.im,
            this.re * b.im + this.im * b.re )
    }

    operator fun div(b: CNumber): CNumber{
        val wwc = 1/(b * b.conjugate()).toReal()
        val zwc = this * b.conjugate()
        return zwc * wwc
    }

    operator fun rem(b: CNumber): CNumber{
        return -b * floor(this / b) + this.re + i * this.im
    }

    // binary operators between a real number and a complex number
    operator fun plus(b: Number): CNumber{
        return CNumber(this.re + b.toDouble(),
            this.im)
    }

    operator fun minus(b: Number): CNumber{
        return CNumber(this.re - b.toDouble(),
            this.im)
    }

    operator fun times(b: Number): CNumber{
        return CNumber(this.re * b.toDouble(),
            this.im * b.toDouble())
    }

    operator fun div(b: Number): CNumber{
        return this / b.toComplex()
    }

    //Increments and Decrements
    operator fun inc(parameter: Parameter = Parameter.BOTH): CNumber {
        return when(parameter) {
            Parameter.REAL -> CNumber(re + 1, im)
            Parameter.IMAGINARY -> CNumber(re, im + 1)
            else -> CNumber(re + 1, im + 1)
        }
    }

    operator fun dec(parameter: Parameter = Parameter.BOTH): CNumber {
        return when(parameter) {
            Parameter.REAL -> CNumber(re - 1, im)
            Parameter.IMAGINARY -> CNumber(re, im - 1)
            else -> CNumber(re - 1, im - 1)
        }
    }

    //other operators
    operator fun unaryMinus(): CNumber{
        return CNumber(-1 *  re, -1 * im)
    }

    override operator fun equals(other: Any?): Boolean {
        return when (other) {
            is CNumber -> checkEquals(other)
            is Number -> checkEquals(other.toDouble().toComplex())
            else -> throw InvalidComparison("Cannot compare CNumber to $other")
        }
    }

    // -------------------------------------------------------------
    //overriding Any class methods
    // -------------------------------------------------------------
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

    override fun hashCode(): Int {
        var result = re.hashCode()
        result = 31 * result + im.hashCode()
        return result
    }

    // -------------------------------------------------------------
    // Other methods
    // -------------------------------------------------------------
    private fun checkEquals(b: CNumber): Boolean {
        val roundTo = Constants.getDefaultRound()
        val thisNumber = this.round(roundTo)
        val otherNumber = b.round(roundTo)

        val reals = thisNumber.re() == otherNumber.re()
        val imaginaries = thisNumber.im() == otherNumber.im()

        return reals && imaginaries

    }

    @SuppressWarnings
    fun round(places: Int): CNumber{
        val reRounded = BigDecimal(this.re()).setScale(places, RoundingMode.FLOOR)
        val imRounded = BigDecimal(this.im()).setScale(places, RoundingMode.FLOOR)
        return CNumber(reRounded, imRounded)
    }

    fun roundToGaussianInteger(): CNumber {
        return this.round(0)
    }

    @Suppress("unused")
    fun divides(parameter: CNumber): Boolean {
        return parameter % this == 0.0.toComplex()
    }

    // -------------------------------------------------------------
    // Getters
    // -------------------------------------------------------------
    fun mag(): Double {
        when(mag) { null -> mag = mag(this) }
        return mag!!
    }
    fun arg(): Double {
        when(arg) { null -> arg = arg(this) }
        return arg!!
    }

    // Re and Im functions
    fun re(): Double { return re }
    fun im(): Double { return im }

}
