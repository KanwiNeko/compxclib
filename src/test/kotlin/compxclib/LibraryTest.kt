package compxclib

import kotlin.math.*
import kotlin.test.*
import compxclib.functions.*

class LibraryTest {
    @Test
    fun testMag() {
        assertEquals(5.0,
            ComplexNumber(3, 4).mag(),
            "the magnitude of the complex number should be 5")
    }
    @Test
    fun testArg() {
        assertEquals(
            PI,
            ComplexNumber(-1, 0).arg(),
            "The argument of the complex number -1 + 0i should be pi"
        )
        assertEquals(
            0.0,
            ComplexNumber(1, 0).arg(),
            "The argument of the complex number 1 + 0i should be 0"
        )
    }
    @Test
    fun testSum() {
        assertEquals(ComplexNumber(5.0, 6.0),
            ComplexNumber(1.0, 5.5) + ComplexNumber(4.0, 0.5),
            "The sum should be 5 + 6i"
        )
        assertEquals(
            ComplexNumber(5.0, 6.0),
            ComplexNumber(2.0, 6.0) + 3.0,
            "The sum should be 5 + 6i"
        )
        assertEquals(
            ComplexNumber(7.0, 7.0),
            3.0 + ComplexNumber(4.0, 7.0),
            "The sum should be 7 + 7i"
        )
    }
    @Test
    fun testSubtract() {
        assertEquals(
            ComplexNumber(5.0, 8.0),
            ComplexNumber(10.0, 15.0) - ComplexNumber(5.0, 7.0),
            "The subtraction should be in 5 + 8i"
        )
        assertEquals(
            ComplexNumber(5.0, 8.0),
            ComplexNumber(6.0, 8.0) - 1,
            "The subtraction should be 5 + 8i"
        )
        assertEquals(
            ComplexNumber(4.0, 7.0),
            8.0 - ComplexNumber(4.0, -7.0),
            "The subtraction should be 4 + 7i"
        )
    }
    @Test
    fun testTimes(){
        assertEquals(
            ComplexNumber(-1.0, 8.0),
            ComplexNumber(3.0,2.0) * ComplexNumber(1.0, 2.0),
            "The product should be -1 + 8i"
        )
        assertEquals(
            ComplexNumber(6.0, 8.0),
            ComplexNumber(3.0, 4.0) * 2,
            "The product should be 6 + 8i"
        )
        assertEquals(
            ComplexNumber(15.0, 10.0),
            5 * ComplexNumber(3.0, 2.0),
            "The product should be 15 + 10i"
        )
    }
    @Test
    fun testDivide(){
        assertEquals(
            ComplexNumber(3.0, 2.0),
            ComplexNumber(-1.0, 8.0) / ComplexNumber(1.0, 2.0),
            "The quotient should be 3 + 2i"
        )
        assertEquals(
            ComplexNumber(4.0, 5.0),
            ComplexNumber(8.0, 10.0) / 2.0,
            "The quotient should be 4 + 5i"
        )
        assertEquals(
            ComplexNumber(1.0, -1.0),
            6.0 / ComplexNumber(3.0, 3.0),
            "The quotient should be 1 - i"

        )
    }
    @Test
    fun testToString() {
        assertEquals(
            "3 + 4i",
            (ComplexNumber(2.5, 4) + ComplexNumber(0.5, 0)).toString()
        )
    }
    @Test
    fun testExp(){
        assertEquals(
            ComplexNumber(-1,0),
            exp(ComplexNumber(0, PI))
        )
        assertEquals(
            ComplexNumber(-1,0),
            ComplexNumber(0, 1).pow(2)
        )
    }
    /*@Test
    fun testPolar(){
        assertEquals(
            CNumber(1,1),
            complexFromPolar(PI/4, sqrt(2.0))
        )
    }*/
    @Test
    fun testToGaussianInteger() {
        assertEquals(
            ComplexNumber(4.0, 5.0),
            ComplexNumber(4.5, 5.1).roundToGaussianInteger()
        )
    }
}
