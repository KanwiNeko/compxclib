package compxclib

//Main complex class
data class CNumber<T: Number>(val real: T, val imaginary: T){
    val magnitude: Double = this.mag()
    val argument: Double = this.arg()
    override fun toString(): String {
        return real.toString() + " + " + imaginary.toString() + "i"
    }

    // main methods of the class
    private fun mag(): Double {
        return mag(this)
    }

    private fun arg(): Double {
        return arg(this)
    }

    @SuppressWarnings
    fun conjugate(): CNumber<Double>{
        return CNumber(this.real.toDouble(), -1 * this.imaginary.toDouble())
    }

    @SuppressWarnings
    fun toReal(): Double {
        if (this.imaginary.toDouble() == 0.0) {
            return this.real.toDouble()
        } else {
            println(this.toString())
            throw IllegalConversionArgument("This number has a non zero imaginary part.")
        }
    }

    // definition of operators

    // operators between complex numbers
    operator fun plus(b: CNumber<*>): CNumber<Double>{
        return CNumber(this.real.toDouble() + b.real.toDouble(),
            this.imaginary.toDouble() + b.imaginary.toDouble())
    }

    operator fun minus(b: CNumber<*>): CNumber<Double>{
        return CNumber(this.real.toDouble() - b.real.toDouble(),
            this.imaginary.toDouble() - b.imaginary.toDouble())
    }

    operator fun times(b: CNumber<*>): CNumber<Double> {
        return CNumber(this.real.toDouble() * b.real.toDouble() - this.imaginary.toDouble() * b.imaginary.toDouble(),
            this.real.toDouble() * b.imaginary.toDouble() + this.imaginary.toDouble() * b.real.toDouble() )
    }

    operator fun div(b: CNumber<*>): CNumber<Double>{
        val wwc = 1/((b * b.conjugate()).toReal())
        val zwc = this * b.conjugate()
        return zwc * wwc
    }

    // operators between a real number and a complex number
    operator fun plus(b: Number): CNumber<Double>{
        return CNumber(this.real.toDouble() + b.toDouble(),
            this.imaginary.toDouble())
    }

    operator fun minus(b: Number): CNumber<Double>{
        return CNumber(this.real.toDouble() - b.toDouble(),
            this.imaginary.toDouble())
    }

    operator fun times(b: Number): CNumber<Double>{
        return CNumber(this.real.toDouble() * b.toDouble(),
            this.imaginary.toDouble() * b.toDouble())
    }

    operator fun div(b: Number): CNumber<Double>{
        return this / b.toComplex<Double>()
    }

}