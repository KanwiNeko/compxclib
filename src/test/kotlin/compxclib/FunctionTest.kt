package compxclib

import compxclib.enums.SqrtBranch
import compxclib.functions.*
import compxclib.operators.i
import compxclib.operators.plus
import compxclib.operators.times
import kotlin.math.cosh
import kotlin.test.Test
import kotlin.test.assertEquals

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
    @Test
    fun arccosTest(){
        assertEquals(
            -i * 1.3169578969248172,
            arccos(2.toComplex(), SqrtBranch.POSITIVE, 0)
            )
        }
    @Test
    fun arcsinhTest() {
        assertEquals(
            ComplexNumber(
                3.1817205225071623,
                0.7249311476979179
            ),
            arcsinh(ComplexNumber(9, 8))
        )
    }
    @Test
    fun arccoshTest() {
        assertEquals(
            ComplexNumber(
                3.1817205225071623,
                0.8458651790969788
            ),
            arccosh(ComplexNumber(8,9))
        )
    }
    @Test
    fun arctanhTest() {
        assertEquals(
            ComplexNumber(
            0.020266955772195432,
            1.5451777430931872),
            arctanh(ComplexNumber(19, 24)))
    }
    @Test
    fun arccothTest() {
        assertEquals(
            ComplexNumber(
                0.1175009073114339,
                -0.1608752771983211
            ),
            arccoth(ComplexNumber(3, 4))
        )
    }
    @Test
    fun arcsechTest() {
        assertEquals(
            ComplexNumber(
                0.10571433752337997,
                1.54739564669074
            ),
            arcsech(ComplexNumber(2, -9))
        )
    }
    @Test
    fun arccschTest() {
        assertEquals(
            ComplexNumber(
                -0.5306375309525179,
                0.4522784471511907
            ),
            arccsch(ComplexNumber(-1, -1))
        )
    }

    @Test
    fun iTest() {
        assertEquals(
            ComplexNumber(5, 6),
            5 + 6.i
        )
    }
}