package compxclib.parser

import compxclib.ComplexNumber
import compxclib.Sign

internal object ComplexLexer {
    private lateinit var tokenList: MutableComplexList
    private var lastEatenToken: TokenTuple? = null
    private var index = 0

    fun eat(): Pair<TokenTuple, Int> {
        val eatenToken = tokenList[0]
        tokenList.removeAt(0)
        this.lastEatenToken = eatenToken
        index++
        return Pair(eatenToken, index)
    }

    fun complexLexer(complexList: ComplexList): Pair<ComplexList, List<ComplexNumber>> {
        this.tokenList = complexList.toMutableList()
        val returnedComplexList: List<ComplexNumber> = mutableListOf()
        while (tokenList.isNotEmpty()) {

        }
    }
}