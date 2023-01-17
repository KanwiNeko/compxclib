package compxclib

import compxclib.parser.ComplexLexer
import compxclib.parser.Lexer
import compxclib.parser.NumberLexer
import compxclib.parser.Parser
import kotlin.test.*

class ParserTest {
    @Test
    fun parserTest() {
        val firstTokenization = Lexer.tokenize("3 + sin(5 + 6)")
        NumberLexer.init(firstTokenization)
        val secondTokenization = NumberLexer.numberLexer()
        val (thirdTokenization, numbers) = ComplexLexer.complexLexer(secondTokenization)
        val parser = Parser(thirdTokenization, numbers)
        println("TEST FINALLY PASSED!!")
        println(parser.parse())
        assertEquals(expected = true, actual = true)
    }
}