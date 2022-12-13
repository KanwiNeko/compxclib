package compxclib.functions

import compxclib.CNumber
import compxclib.Library
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
	val real = (modulus.toDouble() * cos(theta.toDouble())).roundToLong()
	val imaginary = (modulus.toDouble() * sin(theta.toDouble())).roundToLong()
	return CNumber(real, imaginary)
}

// Extensions of methods
@Suppress("unused")
fun Number.toComplex(): CNumber {
	val num = this.toDouble()
	return CNumber(num, 0)
}