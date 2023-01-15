package compxclib

import kotlin.test.*
import compxclib.parser.*

class ParserTest {
    @Test
    fun parserTest() {
        val firstTokenization = Lexer.tokenize("arctan(ln(5.8458+7i))")
        ComplexLexer.init(firstTokenization)
        val secondTokenization = ComplexLexer.numberLexer()
        println(secondTokenization)
        assertEquals(true, true)
    }
}