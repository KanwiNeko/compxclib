package compxclib

import kotlin.math.*

//Magnitude of the number, hypotenuse of the triangle with sides
//Im(z) and Re(z)
fun mag(number: CNumber<*>): Double {
	return sqrt(number.real.toDouble().pow(2) + number.imaginary.toDouble().pow(2))
}

//Argument of the number
fun arg(number: CNumber<*>): Double {
	val rarg = atan(number.imaginary.toDouble() /
			number.real.toDouble())
	//The argument of a complex number is always between (-pi, pi]
	return when{
		number.imaginary.toDouble() > 0 && number.real.toDouble() < 0 -> rarg + PI
		number.imaginary.toDouble() < 0 && number.real.toDouble() < 0 -> rarg - PI
		number.imaginary.toDouble() == 0.toDouble() && number.real.toDouble() < 1 -> PI
		else -> rarg
	}
}

// to complex functions, where we define the conversion between reals and complex
// we also are able to convert between different complex classes
/*@Suppress("unused")
inline fun <reified T: Number> toComplex(number: T): CNumber<T>{
	val num = number.toDouble()
	return CNumber(num.round(), 0.toDouble().round())
}*/

// to convert a complex value to another complex value
@Suppress("unused")
inline fun <reified T: Number> toComplex(num: CNumber<T>): CNumber<T>{
	val re = num.real.toDouble().round<T>()
	val im = num.imaginary.toDouble().round<T>()
	return CNumber(re, im)
}

@Suppress("unused")
inline fun <reified T: Number> complexFromPolar(theta: T, modulus: T): CNumber<T> {
	val real = modulus.toDouble() * cos(theta.toDouble())
	val imaginary = modulus.toDouble() * sin(theta.toDouble())
	return CNumber(real.round(), imaginary.round())
}


// Extensions of methods
@Suppress("unused")
inline fun <reified T: Number> Number.toComplex(): CNumber<T> {
	val num = this.toDouble()
	return CNumber(num.round(), 0.toDouble().round())
}

inline fun <reified T : Number> Double.round(): T {
	return if (T::class == Int::class) {
		this.roundToInt() as T
	} else {
		this as T
	}
}