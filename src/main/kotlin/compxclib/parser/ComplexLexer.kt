package compxclib.parser

import compxclib.ComplexNumber

class ComplexLexer(private val complexList: ComplexList) {

    // static variables used for checking
    private val leftParenthesisToken = Pair(Tokens.STRUCTURE, "(")
    private val rightParenthesisToken = Pair(Tokens.STRUCTURE, ")")
    private val positiveOperatorToken = Pair(Tokens.OPERATOR, "+")
    private val numbers = arrayOf(
        Tokens.REAL_NUMBER,
        Tokens.IMAGINARY_NUMBER
    )

    // dynamic variables using during logic
    private var tokenList: MutableComplexList = this.complexList.toMutableList()
    private var index = 0

    // parses a string into a double
    @OptIn(ExperimentalStdlibApi::class)
    private fun parseDouble(input: String): Double {
        val sign: Double = when(input[0]) {
            '+' -> 1.0
            '-' -> -1.0
            else -> 0.0
        }
        val number: Double = input
            .removeRange(0 ..< 1)
            .toDouble()
        return number * sign
    }

    // returns the token to each side of the given token
    private fun neighbors(index: Int): Pair<TokenTuple?, TokenTuple?> {
        return Pair(
            try {
                tokenList[index-1]
            } catch(_: IndexOutOfBoundsException) {
                null
            },
            try {
                tokenList[index+1]
            } catch (_: IndexOutOfBoundsException) {
                null
            }
        )
    }

    // returns the first element of the list
    private fun at(): TokenTuple {
        return tokenList[0]
    }

    // removes first token in the list, adds the eaten token to the lastEatenToken variable and returns the token
    private fun eat(): TokenTuple {
        val eatenToken = tokenList[0]
        tokenList.removeAt(0)
        index++
        return eatenToken
    }

    // deletes stray operators; ex: ln(4+) -> ln(4) or sin(+2) -> sin(2) or +4 -> 4
    @OptIn(ExperimentalStdlibApi::class)
    private fun cleanTokenList(): Int {
        val removedIndexes = mutableListOf<Int>()
        for ((i, v) in tokenList.zip(0 ..< tokenList.size)) {
            val (leftNeighbor, rightNeighbor) = neighbors(v)
            if (i.first != Tokens.OPERATOR) continue
            if (leftNeighbor == leftParenthesisToken || leftNeighbor == null) {
                removedIndexes += v; continue
            }
            if (rightNeighbor == rightParenthesisToken || rightNeighbor == null) {
                removedIndexes += v; continue
            }
            if (leftNeighbor.first == Tokens.OPERATOR && rightNeighbor.first in numbers) {
                removedIndexes += v; continue
            }
        }
        removedIndexes.reverse()
        for (i in removedIndexes) {
            tokenList.removeAt(i)
        }
        return removedIndexes.size
    }

    fun complexLexer(): Pair<ComplexList, List<ComplexNumber>> {
        // Assignments
        val returnedList: MutableComplexList = mutableListOf()
        val returnedComplexList: MutableList<ComplexNumber> = mutableListOf()

        // Pre-lexing logic
        var elementsRemoved: Int? = null
        while (elementsRemoved != 0) {
            elementsRemoved = cleanTokenList()
        }

        // Main Logic
        while (tokenList.isNotEmpty()) {
            if(at().first !in numbers) { returnedList += eat(); continue }

            var real: Double? = null
            var imaginary: Double? = null
            val number = eat()
            when (number.first) {
                Tokens.REAL_NUMBER -> { real = parseDouble(number.second) ; imaginary = null }
                Tokens.IMAGINARY_NUMBER -> { imaginary = parseDouble(number.second) ; real = null}
                else -> Unit
            }
            val sign = eat()
            if (sign == positiveOperatorToken) {
                @Suppress("KotlinConstantConditions")
                when (null) {
                    real -> {
                        real = if (at().first == Tokens.REAL_NUMBER) {
                            returnedList += Pair(Tokens.COMPLEX_NUMBER, "${returnedComplexList.size}")
                            parseDouble(eat().second)
                        } else {
                            returnedList += Pair(Tokens.COMPLEX_NUMBER, "${returnedComplexList.size}")
                            returnedList += sign
                            0.0
                        }
                    }
                    @Suppress("") imaginary -> {
                        imaginary = if (at().first == Tokens.IMAGINARY_NUMBER) {
                            returnedList += Pair(Tokens.COMPLEX_NUMBER, "${returnedComplexList.size}")
                            parseDouble(eat().second)
                        } else {
                            returnedList += Pair(Tokens.COMPLEX_NUMBER, "${returnedComplexList.size}")
                            returnedList += sign
                            0.0
                        }
                    }
                }
            } else {
                @Suppress("KotlinConstantConditions")
                when (null) {
                    real -> real = 0.0
                    imaginary -> imaginary = 0.0
                }
                returnedList += Pair(Tokens.COMPLEX_NUMBER, "${returnedComplexList.size}")
                returnedList += sign
            }
            returnedComplexList += ComplexNumber(real!!, imaginary!!)
        }
        return Pair(returnedList, returnedComplexList)
    }
}