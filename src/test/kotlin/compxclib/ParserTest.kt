package compxclib

import compxclib.functions.sin
import compxclib.parser.Parser
import kotlin.test.*

class ParserTest {
    @Test
    fun parserTest() {
        Constants.setDefaultRound(10)
        val expected = sin(ComplexNumber(34*34, 0))*ComplexNumber(0, 8)
        val input = "sin(34^2)*8i"
        val parser = Parser(input)
        val result = parser.parse()
        println("[INFO]: Expecting result $expected")
        println("[INFO]: Result of $input = $result")
        assertEquals(expected, result)
    }
}