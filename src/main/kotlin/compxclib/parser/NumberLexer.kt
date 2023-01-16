package compxclib.parser

import compxclib.NumberLexerNotInitialized
import compxclib.Sign

typealias TokenTuple = Pair<Tokens, String>
typealias ComplexList = List<TokenTuple>
typealias MutableComplexList = MutableList<TokenTuple>

internal object NumberLexer {
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

    fun init(tokenList: ComplexList) {
        this.tokenList = tokenList.toMutableList()
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

    fun numberLexer(): ComplexList {
        if (tokenList.isNullOrEmpty()) throw NumberLexerNotInitialized("Call NumberLexer.init(your token list) before using this!")
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