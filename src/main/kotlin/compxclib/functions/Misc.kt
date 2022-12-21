package compxclib.functions

import compxclib.ComplexNumber
import compxclib.Constants
import kotlin.math.*

val i = Constants.i()
//Magnitude of the number, hypotenuse of the triangle with sides
//Im(z) and Re(z)
fun mag(of: ComplexNumber): Double {
	return sqrt(of.re().pow(2) + of.im().pow(2))
}

//Argument of the number
fun arg(of: ComplexNumber): Double {
	return atan2(of.im(), of.re())
}

// to complex functions, where we define the conversion between reals and complex
// we also are able to convert between different complex classes

@Suppress("unused")
fun complexFromPolar(theta: Number, modulus: Number): ComplexNumber {
	val real = (modulus.toDouble() * cos(theta.toDouble())).roundToLong()
	val imaginary = (modulus.toDouble() * sin(theta.toDouble())).roundToLong()
	return ComplexNumber(real, imaginary)
}

// Extensions of methods
@Suppress("unused")
fun Number.toComplex(): ComplexNumber {
	val num = this.toDouble()
	return ComplexNumber(num, 0)
}