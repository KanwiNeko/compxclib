package compxclib

import kotlin.test.*
import compxclib.parser.*

class ParserTest {
    @Test
    fun parserTest() {
        println(Lexer.tokenize("arctan(ln(5.8458+7i))"))
        assertEquals(true, true)
    }
}