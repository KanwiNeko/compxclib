package compxclib.parser

import compxclib.Constants
import compxclib.InvalidToken
import java.lang.Double.parseDouble

internal object Lexer {

    private var stream = ""
    private var cursor = 0

    private fun at(): Char {
        return this.stream[this.cursor]
    }

    private fun isNumeric(str: String): Boolean {
        var result = true
        try {
            parseDouble(str)
        } catch (e: NumberFormatException) {
            result = false
        }
        return result
    }

    fun tokenize(input: String): List<Pair<Tokens, String>> {
        val tokens: MutableList<Pair<Tokens, String>> = mutableListOf()

        this.stream = input
        this.cursor = 0
        while(this.cursor < this.stream.length) {
            when (this.at()) {
                ' ' -> Unit
                '\n' -> Unit
                '\t' -> Unit
                '+' -> tokens += Pair(Tokens.OPERATOR, "+")
                '-' -> tokens += Pair(Tokens.OPERATOR, "-")
                '*' -> tokens += Pair(Tokens.OPERATOR, "*")
                '/' -> tokens += Pair(Tokens.OPERATOR, "/")
                '^' -> tokens += Pair(Tokens.OPERATOR, "^")
                'i' -> tokens += Pair(Tokens.IMAGINARY_UNIT, "")
                // structure
                '(' -> tokens += Pair(Tokens.STRUCTURE, "(")
                ')' -> tokens += Pair(Tokens.STRUCTURE, ")")
                '[' -> tokens += Pair(Tokens.STRUCTURE, "[")
                ']' -> tokens += Pair(Tokens.STRUCTURE, "]")
                '{' -> tokens += Pair(Tokens.STRUCTURE, "{")
                '}' -> tokens += Pair(Tokens.STRUCTURE, "}")
                '|' -> tokens += Pair(Tokens.STRUCTURE, "|")
                // other
                else -> {
                    if (isNumeric(this.at().toString())) {
                        var strNumber = ""
                        while (this.cursor < this.stream.length && (isNumeric(this.at().toString()) || this.at() == '.')) {
                            strNumber += this.at()
                            this.cursor++
                        }

                        tokens += Pair(Tokens.NUMBER, strNumber)
                        this.cursor--
                    }else {
                        var willContinue = false
                        val oldCursor = this.cursor
                        var methodString = ""
                        while (this.cursor < this.stream.length && this.cursor < this.cursor + Constants.getMaxMethodNameSize()){
                            methodString += this.at()
                            if (methodString in Dictionaries.methodAliases) {
                                willContinue = true
                                tokens += Pair(Tokens.METHOD, methodString)
                                break
                            }
                            this.cursor++
                        }
                        if (!willContinue) {
                            this.cursor = oldCursor
                            throw InvalidToken("Invalid token at position ${this.cursor}:${this.at()}")
                        }
                    }
                }
            }
            this.cursor++
        }
        tokens += Pair(Tokens.EOF, "End Of File")
        return tokens
    }

}