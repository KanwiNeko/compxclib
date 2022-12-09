package compxclib

import kotlin.math.PI
import kotlin.test.Test
import kotlin.test.assertEquals

class LibraryTest {
    @Test
    fun testMag() {
        assertEquals(5.0,
            CNumber(3, 4).magnitude,
            "the magnitude of the complex number should be 5")
    }
    @Test
    fun testArg() {
        assertEquals(
            PI,
            CNumber(-1, 0).argument,
            "The argument of the complex number -1 + 0i should be pi"
        )
        assertEquals(
            0.0,
            CNumber(1, 0).argument,
            "The argument of the complex number 1 + 0i should be 0"
        )
    }
    @Test
    fun testSum() {
        assertEquals(
            CNumber(5.0, 6.0),
            CNumber(1.0, 5.5) + CNumber(4.0, 0.5),
            "The sum should be 5 + 6i"
        )
        assertEquals(
            CNumber(5.0, 6.0),
            CNumber(2.0, 6.0) + 3.0,
            "The sum should be 5 + 6i"
        )
        assertEquals(
            CNumber(7.0, 7.0),
            3.0 + CNumber(3.0, 7.0),
            "The sum should be 7 + 7i"
        )
    }
    @Test
    fun testSubtract() {
        assertEquals(
            CNumber(5.0, 8.0),
            CNumber(10.0, 15.0) - CNumber(5.0, 7.0),
            "The subtraction should be in 5 + 8i"
        )
        assertEquals(
            CNumber(5.0, 8.0),
            CNumber(6.0, 8.0) - 1,
            "The subtraction should be 5 + 8i"
        )
        assertEquals(
            CNumber(4.0, 7.0),
            8.0 - CNumber(4.0, -7.0),
            "The subtraction should be 4 + 7i"
        )
    }
    @Test
    fun testTimes(){
        assertEquals(
            CNumber(-1.0, 8.0),
            CNumber(3.0,2.0) * CNumber(1.0, 2.0),
            "The product should be -1 + 8i"
        )
        assertEquals(
            CNumber(6.0, 8.0),
            CNumber(3.0, 4.0) * 2,
            "The product should be 6 + 8i"
        )
        assertEquals(
            CNumber(15.0, 10.0),
            5 * CNumber(3.0, 2.0),
            "The product should be 15 + 10i"
        )
    }
    @Test
    fun testDivide(){
        assertEquals(
            CNumber(3.0, 2.0),
            CNumber(-1.0, 8.0) / CNumber(1.0, 2.0),
            "The quotient should be 3 + 2i"
        )
        assertEquals(
            CNumber(4.0, 5.0),
            CNumber(8.0, 10.0) / 2.0,
            "The quotient should be 4 + 5i"
        )
        assertEquals(
            CNumber(1.0, -1.0),
            6.0 / CNumber(3.0, 3.0),
            "The quotient should be 1 - i"

        )
    }
}
