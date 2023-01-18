package compxclib.parser

import compxclib.ComplexNumber

class Parser(private val input: String) {
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

    override fun toString(): String {
        return "Parsing the expression: $input"
    }
}