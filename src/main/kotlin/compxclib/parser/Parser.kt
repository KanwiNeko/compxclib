package compxclib.parser

import compxclib.InvalidToken

object Parser {
    private var tokens: List<Pair<Tokens, String>> = listOf()

    private var cursor = 0

    private fun at(): Pair<Tokens, String> {
        return tokens[cursor]
    }

    private fun eatToken(tokenType: Tokens) {
        if (tokenType == at().first) {
            this.cursor++;
        } else {
            throw InvalidToken("Invalid token type, expected: $tokenType, got: ${at().first}")
        }
    }

    private fun peek(n: Int): Pair<Tokens, String> {
        return tokens[cursor + n]
    }


    // Addition and subtraction
    private fun parseExpression() {

    }

    // Multiplication or division
    private fun parseTerm() {

    }

    //Parse the functions used
    private fun parseFunction() {

    }

    //Find the complex numbers inside the string
    private fun parseNumber() {

    }

    // highest
    private fun parseFactor() {

    }

    public fun parse() {
        return parseExpression()
    }

}