package compxclib

import kotlin.math.*
val i = Library.i
//Magnitude of the number, hypotenuse of the triangle with sides
//Im(z) and Re(z)
fun mag(cNumber: CNumber): Double {
	return sqrt(cNumber.re().pow(2) + cNumber.im().pow(2))
}

//Argument of the number
fun arg(number: CNumber): Double {
	val rarg = atan(number.im() /
			number.re())
	//The argument of a complex number is always between (-pi, pi]
	return when{
		number.im() > 0 && number.re() < 0 -> rarg + PI
		number.im() < 0 && number.re() < 0 -> rarg - PI
		number.im() == 0.toDouble() && number.re() < 1 -> PI
		else -> rarg
	}
}

// to complex functions, where we define the conversion between reals and complex
// we also are able to convert between different complex classes

@Suppress("unused")
fun complexFromPolar(theta: Number, modulus: Number): CNumber {
	val real = modulus.toDouble() * cos(theta.toDouble())
	val imaginary = modulus.toDouble() * sin(theta.toDouble())
	return CNumber(real, imaginary)
}

// Extensions of methods
@Suppress("unused")
fun Number.toComplex(): CNumber {
	val num = this.toDouble()
	return CNumber(num, 0)
}

// complex logarithms
fun ln(of: CNumber): CNumber{
	return CNumber(ln(of.magnitude), of.argument)
}

fun log(base: CNumber, of: CNumber): CNumber{
	return ln(of) / ln(base)
}

@Suppress("unused")
fun log(base: Number, of: CNumber): CNumber{
	return log(base.toComplex(), of)
}

// exponential functions
fun exp(of: CNumber): CNumber{
	return exp(of.re()) * CNumber(cos(of.im()).roundToLong(), sin(of.im()).roundToLong())
}

@Suppress("unused")
fun CNumber.pow(to: CNumber): CNumber{
	return exp(to * ln(this))
}

fun CNumber.pow(to: Number): CNumber{
	return exp(to * ln(this))
}

@Suppress("unused")
fun Number.pow(to: CNumber): CNumber{
	return exp(ln(this.toDouble()) * to)
}

@Suppress("unused")
fun sqrt(of: CNumber): CNumber{
	return of.pow(1/2)
}

@Suppress("unused")
fun cbrt(of: CNumber): CNumber{
	return of.pow(1/3)
}

@Suppress("unused")
fun nthrt(of: CNumber, n: Number): CNumber{
return of.pow(1/n.toDouble())
}

// trigonometric functions
@Suppress("unused")
fun sin(of: CNumber): CNumber{
	return (1/2) * (exp(Library.i * of) - exp( -1 * Library.i * of))
}

@Suppress("unused")
fun cos(of: CNumber): CNumber{
	return (1/2) * (exp(Library.i * of) + exp( -1 * Library.i * of))
}

@Suppress("unused")
fun tan(of: CNumber): CNumber{
	return sin(of) / cos(of)
}

@Suppress("unused")
fun cot(of: CNumber): CNumber{
	return cos(of) / sin(of)
}

@Suppress("unused")
fun sec(of: CNumber): CNumber{
	return 1 / cos(of)
}

@Suppress("unused")
fun csc(of : CNumber): CNumber{
	return 1 / sin(of)
}

//inverse trigonometric functions
fun arcsin(of: CNumber): CNumber {
	return -i * ln(i * of + sqrt(1 - of.pow(2)))
}

@Suppress("unused")
fun arccos(of: CNumber): CNumber{
	return 1/2 * (PI - 2* arcsin(of))
}

@Suppress("unused")
fun arctan(of: CNumber): CNumber{
	return 1/(2*i) * ln((1 - of) / (1 + of))
}

@Suppress("unused")
fun arccot(of: CNumber): CNumber{
	return arctan( 1 / of)
}

@Suppress("unused")
fun arcsec(of: CNumber): CNumber{
	return arccos(1/of)
}

@Suppress("unused")
fun arccsc(of: CNumber): CNumber{
	return arcsin(1/of)
}