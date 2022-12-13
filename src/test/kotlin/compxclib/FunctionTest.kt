package compxclib

import compxclib.Constants
import kotlin.math.*
import kotlin.test.*
import compxclib.functions.*

class FunctionTest {

    private val i = Constants.i()

    @Test
    fun sinTest(){
        assertEquals(
            i * 1.1752011936438014,
            sin(i),
            "The sin of i should be 1.1752i")
        assertEquals(
            CNumber(1.5707963267948966, -1.3169578969248168),
            arcsin(2.toComplex(), 0)[0]
        )
    }
}