package compxclib

import compxclib.parser.parsing.AstTree
import compxclib.parser.lexing.ComplexLexer
import compxclib.parser.lexing.Lexer
import compxclib.parser.lexing.NumberLexer
import compxclib.parser.parsing.Evaluator

/**
 * Parser class, manages all the **parsing and lexing** classes and the user input.
 * @param input First user [String] input
 * @property input User input
 * @constructor Creates a [Parser] class with a [String] input
 * @since Version 1.0
 * @see [compxclib.parser]
 */
class Parser(private var input: String) {
    /**
     * Calls a series of lexing classes and methods that will parse the user input
     * @return ComplexNumber with the parsed value of the user's expression
     * @since Version 1.0
     * @see compxclib.parser
     */
    fun parse(): ComplexNumber {
        val tokenLex = Lexer(this.input)
        val tokens1 = tokenLex.tokenize()
        val numberLex = NumberLexer(tokens1)
        val tokens2 = numberLex.numberLexer()
        val complexLex = ComplexLexer(tokens2)
        val (tokens3, tokensNumber) = complexLex.complexLexer()
        val astTree = AstTree(tokens3, tokensNumber).parse()
        return Evaluator(astTree).evaluate()
    }

    /**
     * Re-sets the [String] expression in the [Parser] class
     * @since Version 1.0
     * @see Parser
     * @see compxclib.parser
     */
    @Suppress("unused")
    fun setInputString(input: String) {
        this.input = input
    }

    /**
     * overrides the default [Any.toString] method and implements one that gives more information
     * @return Information with the classes [input]
     * @since Version 1.0
     * @see Parser
     * @see compxclib.parser
     */
    override fun toString(): String {
        return "Parsing the expression: $input"
    }
}