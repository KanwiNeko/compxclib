package compxclib

import compxclib.functions.sin
import compxclib.parser.Parser
import kotlin.math.PI
import kotlin.test.*

class ParserTest {
    @Test
    fun parserTest() {
        //Constants.setDefaultRound(10)
        val expected = ComplexNumber(-1, 0)
        val input = "exp($PI i)"
        val parser = Parser(input)
        val result = parser.parse()
        println("[INFO]: Expecting result $expected")
        println("[INFO]: Result of $input = $result")
        assertEquals(expected, result)
    }
}