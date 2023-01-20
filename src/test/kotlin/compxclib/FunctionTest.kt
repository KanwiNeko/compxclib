package compxclib

import compxclib.enums.SqrtBranch
import kotlin.test.*
import kotlin.math.cosh
import compxclib.functions.*
import compxclib.operators.times

class FunctionTest {

    private val i = Constants.i()


    @Test
    fun powerOperatorTest() {
        assertEquals(
            ComplexNumber(9, 8).pow(ComplexNumber(1, 6)),
            ComplexNumber(9, 8) pow ComplexNumber(1, 6)
        )
        assertEquals(
            ComplexNumber(9, 8).pow(6),
            ComplexNumber(9, 8) pow 6
        )
    }

    @Test
    fun lnTest() {
        assertEquals(
            1.5707963267948966 * i,
            ln(i)
        )
    }

    @Test
    fun sinTest(){
        assertEquals(
            i * 1.1752011936438014,
            sin(i),
            "The sin of i should be 1.1752i")
    }
    @Test
    fun cosTest(){
        assert(
            cosh(1.0).toComplex() == cos(i)
        )
    }
    @Test
    fun arcsinTest(){
        assertEquals(
            ComplexNumber(1.5707963267948966, 1.3169578969248172),
            arcsin( 2.toComplex(), SqrtBranch.POSITIVE, 0)
        )
    }
    /*@Test
    fun arccosTest(){
        assertEquals(
            -i * 1.3169578969248172,
            arccos(2.toComplex(), SqrtBranch.POSITIVE, 0)
            )
        }*/
}