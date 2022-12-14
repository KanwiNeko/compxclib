package compxclib.functions

import compxclib.CNumber
import compxclib.Constants
import kotlin.math.*

val i = Constants.i()
//Magnitude of the number, hypotenuse of the triangle with sides
//Im(z) and Re(z)
fun mag(of: CNumber): Double {
	return sqrt(of.re().pow(2) + of.im().pow(2))
}

//Argument of the number
fun arg(of: CNumber): Double {
	return atan2(of.im(), of.re())
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