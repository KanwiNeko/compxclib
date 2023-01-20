package compxclib.parser.lexing

import compxclib.enums.Sign
import compxclib.parser.data.ComplexList
import compxclib.parser.data.MutableComplexList
import compxclib.parser.data.TokenTuple
import compxclib.parser.data.Tokens

/**
 * Tokenizing class with a single public main method, the purpose of this class is to
 * **receive, modify and return data from the** [Lexer] class; it is the middle in the tokenization process
 *
 * The values returned by this class are designed to be passed to the [ComplexLexer] class constructor
 * @param tokens a [ComplexList]
 * @since Version 1.0
 * @see [Lexer]
 * @see [NumberLexer]
 * @see [ComplexList]
 */
class NumberLexer(tokens: ComplexList) {
    private var tokenList: MutableComplexList? = null
    private var returnedList: MutableComplexList = mutableListOf()

    private val skipTypes = arrayOf(
        Tokens.EOF,
        Tokens.FUNCTION,
        Tokens.STRUCTURE,
        Tokens.COMPLEX_NUMBER,
        Tokens.REAL_NUMBER,
        Tokens.IMAGINARY_NUMBER
    )

    init {
        this.tokenList = tokens.toMutableList()
    }

    private val validOperators = arrayOf(
        Pair(Tokens.OPERATOR, "+"),
        Pair(Tokens.OPERATOR, "-")
    )

    private fun eatToken(): TokenTuple {
        val temp = tokenList!![0]
        tokenList!!.removeAt(0)
        return temp
    }

    private fun at(): TokenTuple {
        return tokenList!![0]
    }

    private fun nLexer(sign: Sign) {
        val signString = when(sign) {
            Sign.POSITIVE -> "+"
            Sign.NEGATIVE -> "-"
        }
        when (at().first) {
            Tokens.NUMBER -> {
                returnedList += Pair(Tokens.OPERATOR, "+")
                val numb = eatToken().second
                returnedList += if (at().first == Tokens.IMAGINARY_UNIT) {
                    eatToken()
                    Pair(Tokens.IMAGINARY_NUMBER, "$signString$numb")
                } else {
                    Pair(Tokens.REAL_NUMBER, "$signString$numb")
                }
            }
            Tokens.IMAGINARY_UNIT -> {
                returnedList += Pair(Tokens.OPERATOR, "+")
                eatToken()
                returnedList += if (at().first == Tokens.NUMBER) {
                    val number = eatToken().second
                    Pair(Tokens.IMAGINARY_NUMBER, "$signString$number")
                } else {
                    Pair(Tokens.IMAGINARY_NUMBER, "${signString}1")
                }
            }
            else -> {
                returnedList += when (sign) {
                    Sign.POSITIVE -> Pair(Tokens.OPERATOR, "+")
                    Sign.NEGATIVE -> Pair(Tokens.OPERATOR, "-")
                }
            }
        }
    }

    /**
     * **Only** public method of the class, evaluates a [ComplexList] to convert the
     * [Tokens.IMAGINARY_UNIT] and [Tokens.NUMBER] values into [Tokens.REAL_NUMBER] and
     * [Tokens.IMAGINARY_NUMBER] values.
     *
     * the returned value *should* be passed to the [ComplexLexer] class constructor
     * @return a [ComplexList] with [Tokens.REAL_NUMBER] and [Tokens.IMAGINARY_NUMBER] values instead of [Tokens.NUMBER] and [Tokens.IMAGINARY_UNIT]
     * @since Version 1.0
     * @see Tokens
     * @see ComplexList
     * @see ComplexLexer
     */
    fun numberLexer(): ComplexList {
        while (tokenList!!.isNotEmpty()) {
            if (at().first in skipTypes) {
                returnedList += eatToken()
                continue
            }
            when(at().first) {
                Tokens.OPERATOR -> {
                    if (at() in validOperators) {
                    when(eatToken().second) {
                        "+" -> nLexer(Sign.POSITIVE)
                        "-" -> nLexer(Sign.NEGATIVE)
                    }
                    } else {
                        returnedList += eatToken()
                    }
                }
                Tokens.NUMBER, Tokens.IMAGINARY_UNIT -> {
                    nLexer(Sign.POSITIVE)
                }
                else -> {}
            }
        }
        return returnedList.toList()
    }

}