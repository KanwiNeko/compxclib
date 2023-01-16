package compxclib.parser

import compxclib.ComplexNumber
import compxclib.InvalidOperatorCall
import compxclib.Sign

internal object ComplexLexer {
    private lateinit var tokenList: MutableComplexList
    private lateinit var referenceTokenList: ComplexList
    private val plusToken = Pair(Tokens.OPERATOR, "+")
    private val leftParenthesisToken = Pair(Tokens.STRUCTURE, "(")
    private val rightParenthesisToken = Pair(Tokens.STRUCTURE, ")")
    private val numbers = arrayOf(
        Tokens.REAL_NUMBER,
        Tokens.IMAGINARY_NUMBER
    )
    private var lastEatenToken: TokenTuple? = null
    private var index = 0

    private fun at(): Pair<TokenTuple, Int> {
        return Pair(tokenList[0], index)
    }

    private fun eat(): Pair<TokenTuple, Int> {
        val eatenToken = tokenList[0]
        tokenList.removeAt(0)
        this.lastEatenToken = eatenToken
        index++
        return Pair(eatenToken, index)
    }

    private fun eat(times: Int) {
        repeat(times) { eat() }
    }

    private fun neighbors(): Pair<TokenTuple?, TokenTuple?> {
        val rightSide: TokenTuple? = try {
            referenceTokenList[index+1]
        } catch (_: IndexOutOfBoundsException) {
            null
        }
        val leftSide: TokenTuple? = try {
            referenceTokenList[index-1]
        } catch (_: IndexOutOfBoundsException) {
            null
        }
        return Pair(leftSide, rightSide)
    }

    private fun isValid(): Boolean {
        val (leftNeighbor, rightNeighbor) = neighbors()
        return when (leftNeighbor) {
            leftParenthesisToken -> { eat() ; false }
            null -> { eat() ; false }
            else ->
                when (rightNeighbor) {
                    rightParenthesisToken -> { eat() ; false }
                    null -> { eat() ; false }
                    else -> true
                }
        }
    }

    fun joinsTwoNumbers(): Boolean {
        val (leftNeighbor, rightNeighbor) = neighbors()
        return leftNeighbor!!.first in numbers && rightNeighbor!!.first in numbers
    }

    fun complexLexer(complexList: ComplexList): Pair<ComplexList, List<ComplexNumber>> {
        this.referenceTokenList = complexList
        this.tokenList = complexList.toMutableList()
        val returnedList: MutableComplexList = mutableListOf()
        val returnedComplexList: List<ComplexNumber> = mutableListOf()
        while (tokenList.isNotEmpty()) {
            if (at() != plusToken) { returnedList += eat().first  ; continue }
            if (!isValid()) continue
        }
        return Pair(returnedList, returnedComplexList)
    }
}