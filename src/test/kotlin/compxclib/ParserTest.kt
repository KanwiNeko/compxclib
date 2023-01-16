package compxclib

import compxclib.parser.ComplexLexer
import compxclib.parser.Lexer
import compxclib.parser.NumberLexer
import kotlin.test.*

class ParserTest {
    @Test
    fun parserTest() {
        val firstTokenization = Lexer.tokenize("*4 + 5i + 6 * ln(i8)")
        NumberLexer.init(firstTokenization)
        val secondTokenization = NumberLexer.numberLexer()
        val (thirdTokenization, numbers) = ComplexLexer.complexLexer(secondTokenization)
        println("Tokens: $thirdTokenization")
        println("Numbers: $numbers")
        assertEquals(true, true)
    }
}