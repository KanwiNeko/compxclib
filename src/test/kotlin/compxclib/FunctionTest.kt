package compxclib

import kotlin.math.*
import kotlin.test.*
import compxclib.functions.*

class FunctionTest {

    val i = Library.i

    @Test
    fun sinTest(){
        assertEquals(i * sinh(1.0f),
            sin(i),
            "The sin of i should be 1.1752i")
    }
}