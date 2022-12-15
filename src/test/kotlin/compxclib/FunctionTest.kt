package compxclib

import kotlin.test.*
import kotlin.math.cosh
import compxclib.functions.*

class FunctionTest {

    private val i = Constants.i()

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
    /*@Test
    fun cosTest(){
        assertEquals(
            cosh((1.0) - 0.0000000000000001).toComplex(),
            cos(i)
        )
    }*/
    @Test
    fun arcsinTest(){
        assertEquals(
            CNumber(1.5707963267948966, 1.3169578969248172),
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