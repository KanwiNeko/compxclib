package compxclib

import kotlin.test.*
import compxclib.parser.*

class ParserTest {
    @Test
    fun parserTest() {
        val firstTokenization = Lexer.tokenize("arctan(ln(5.8458+7i))")
        NumberLexer.init(firstTokenization)
        val secondTokenization = NumberLexer.numberLexer()
        println(secondTokenization)
        assertEquals(true, true)
    }
}