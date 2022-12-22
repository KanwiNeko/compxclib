package compxclib

import kotlin.test.*
import compxclib.parser.*

class ParserTest {
    @Test
    fun parserTest() {
        println(Lexer.tokenize("arctan(ln(5+7i))"))
        assertEquals(true, true)
    }
}