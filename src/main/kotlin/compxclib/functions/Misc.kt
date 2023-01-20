package compxclib.functions

import compxclib.ComplexNumber
import compxclib.Constants
import kotlin.math.*

/**
 * @suppress
 */
val i = Constants.i()

//Magnitude of the number, hypotenuse of the triangle with sides
//Im(z) and Re(z)
/**
 * Magnitude or Modulus of a [ComplexNumber]
 * uses pythagoras theorem to calculate the magnitude of the vector.
 * @param of that is a [ComplexNumber]
 * @return |z|
 * @since Version 1.0
 * @see [ComplexNumber]
 */
fun mag(of: ComplexNumber): Double {
	return sqrt(of.re().pow(2) + of.im().pow(2))
}

//Argument of the number
/**
 * Argument or Angle between basis vectors of a [ComplexNumber].
 * uses the inverse tangent2 of the ratio between the [re()] and [im()] properties.
 * its value resides between -π and π
 * @param of that is a [ComplexNumber]
 * @return Arg(z) **In radians**
 * @since Version 1.0
 * @see [ComplexNumber]
 */
fun arg(of: ComplexNumber): Double {
	return atan2(of.im(), of.re())
}

// to complex functions, where we define the conversion between reals and complex
// we also are able to convert between different complex classes
/**
 * Creates a complex number based on its **Argument** (in radians) and **Modulus**.
 * defined as: `Modulus * (cos(Argument) + i sin(Argument))`
 * @param theta or Argument **IN RADIANS**
 * @param modulus or Modulus
 * @return A new complex number from its parameters
 * @since Version 1.0
 * @see [ComplexNumber.arg]
 * @see [ComplexNumber.mag]
 */
@Suppress("unused")
fun complexFromPolar(theta: Number, modulus: Number): ComplexNumber {
	val real = (modulus.toDouble() * cos(theta.toDouble())).roundToLong()
	val imaginary = (modulus.toDouble() * sin(theta.toDouble())).roundToLong()
	return ComplexNumber(real, imaginary)
}

// Extensions of methods
/**
 * Creates a new complex number whose **real** part is a [Number]
 * @return [ComplexNumber] with `0` as its imaginary part
 * @since Version 1.0
 */
@Suppress("unused")
fun Number.toComplex(): ComplexNumber {
	val num = this.toDouble()
	return ComplexNumber(num, 0)
}