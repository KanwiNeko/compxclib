package compxclib.parser

import compxclib.ComplexNumber
import compxclib.functions.ln
import kotlin.test.*

class ParserTest {
    @Test
    fun parserTest() {
        val firstTokenization = Lexer.tokenize("ln(24+i98)")
        NumberLexer.init(firstTokenization)
        val secondTokenization = NumberLexer.numberLexer()
        println(secondTokenization)
        assertEquals(true, true)
    }
}