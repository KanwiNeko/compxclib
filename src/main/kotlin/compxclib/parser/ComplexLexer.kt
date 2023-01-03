package compxclib.parser

import compxclib.ComplexNumber

internal object ComplexLexer {

    private var tokenList: List<Pair<Tokens, String>> = listOf()
    private val lexedList: MutableList<Pair<Tokens, String>> = mutableListOf()
    private var index = 0

    fun mainLexer(oldList: List<Pair<Tokens, String>>): List<Pair<Tokens, String>> {
        this.index = 0
        this.tokenList = oldList
        for (i in this.tokenList) {
            if (i.first != Tokens.NUMBER && i.first != Tokens.IMAGINARY_UNIT){
                lexedList += i
                index++
                continue
            }
            val startingIndex = index
            when (i.first) {
                Tokens.NUMBER -> {
                    var nextToken = tokenList[index+1]
                    when(nextToken.first) {
                        Tokens.OPERATOR -> {
                            if (nextToken.second == "+" || nextToken.second == "-") {
                                nextToken = tokenList[index+2]
                                when (nextToken.first) {
                                    Tokens.NUMBER -> {}
                                    Tokens.IMAGINARY_UNIT -> {}
                                    else -> {}
                                }
                            } else continue
                        }
                        Tokens.IMAGINARY_UNIT -> {}
                        else -> {}
                    }
                }
                Tokens.IMAGINARY_UNIT -> {}
                else -> {}
            }
        }
        return lexedList.toList()
    }

}