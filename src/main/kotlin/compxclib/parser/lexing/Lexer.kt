@file:Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")

package compxclib.parser.lexing

import compxclib.Constants
import compxclib.exceptions.InvalidToken
import compxclib.parser.data.ComplexList
import compxclib.parser.data.Dictionaries
import compxclib.parser.data.MutableComplexList
import compxclib.parser.data.Tokens
import java.lang.Double

/**
 * Tokenizing class with a single public main method, the purpose of this class is to
 * **receive, modify and return** data from the user as a [String];
 * it is the first in the tokenization process
 *
 * The values returned by this class are designed to be passed to the [NumberLexer] class constructor
 * @param input a [String]
 * @since Version 1.0
 * @see [NumberLexer]
 * @see [ComplexLexer]
 * @see [ComplexList]
 */
class Lexer(private val input: String) {

    private var stream = ""
    private var cursor = 0

    private fun at(): Char {
        return this.stream[this.cursor]
    }

    private fun isNumeric(str: String): Boolean {
        var result = true
        try {
            Double.parseDouble(str)
        } catch (e: NumberFormatException) {
            result = false
        }
        return result
    }

    /**
     * **Only** public method of the class, evaluates a [String] to convert the
     * [Char] values into [Tokens] values
     *
     * the returned value *should* be passed to the [NumberLexer] class constructor
     * @return a [ComplexList]
     * @since Version 1.0
     * @see Tokens
     * @see ComplexList
     * @see ComplexLexer
     * @see Lexer
     * @see NumberLexer
     * @see String
     * @see Char
     */
    fun tokenize(): ComplexList {
        val tokens: MutableComplexList = mutableListOf()

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
                '%' -> tokens += Pair(Tokens.OPERATOR, "%")
                'i' -> tokens += Pair(Tokens.IMAGINARY_UNIT, "")
                // structure
                '(' -> tokens += Pair(Tokens.STRUCTURE, "(")
                ')' -> tokens += Pair(Tokens.STRUCTURE, ")")
                /*
                '[' -> tokens += Pair(Tokens.STRUCTURE, "[")
                ']' -> tokens += Pair(Tokens.STRUCTURE, "]")
                '{' -> tokens += Pair(Tokens.STRUCTURE, "{")
                '}' -> tokens += Pair(Tokens.STRUCTURE, "}")
                '|' -> tokens += Pair(Tokens.STRUCTURE, "|")
                */
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
                            if (methodString in Dictionaries.functionAliases) {
                                willContinue = true
                                tokens += Pair(Tokens.FUNCTION, methodString)
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