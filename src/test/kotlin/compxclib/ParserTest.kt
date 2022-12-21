package compxclib

import kotlin.test.*
import compxclib.parser.*

class ParserTest {
    @Test
    fun parserTest() {
        println(Lexer.tokenize("4567+i + 5* 7773456"))
        assertEquals(true, true)
    }
}