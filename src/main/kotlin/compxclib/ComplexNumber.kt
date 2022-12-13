package compxclib

import compxclib.functions.*
import kotlin.jvm.Throws
import kotlin.math.*

//Main complex class
data class CNumber(private val real: Number,private val imaginary: Number){
    private val re = real.toDouble()
    private val im = imaginary.toDouble()
    val magnitude: Double = mag(this)
    val argument: Double = arg(this)

    // main methods of the class
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

    // definition of operators
    // between complex numbers
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

    // operators between a real number and a complex number
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

    operator fun unaryMinus(): CNumber{
        return CNumber(-1 *  re, -1 * im)
    }

    override fun toString(): String {
        return if (floor(re) == ceil(re) && floor(im) == ceil(im)) {
            re.roundToInt().toString() + " + " + im.roundToInt().toString() + "i"
        } else
            re.toString() + " + " + im.toString() + "i"
    }

    // Re and Im functions
    fun re(): Double { return re }
    fun im(): Double { return im }

}
