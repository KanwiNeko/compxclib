package compxclib.parser

import compxclib.ComplexNumber
import compxclib.exceptions.InvalidToken
import compxclib.enums.Operator
import kotlin.properties.Delegates

class AstTree(tks: ComplexList, private val numbers: List<ComplexNumber>) {
    // Declarations
    private var tokens: ComplexList = listOf()
    private var cursor by Delegates.notNull<Int>()

    private val additiveOperators = arrayOf(
        Pair(Tokens.OPERATOR, "+"),
        Pair(Tokens.OPERATOR, "-")
    )

    private val multiplicativeOperators = arrayOf (
        Pair(Tokens.OPERATOR, "*"),
        Pair(Tokens.OPERATOR, "/"),
        Pair(Tokens.OPERATOR, "%")
    )

    init {
        this.tokens = tks
        this.cursor = 0
    }

    // Scanner Methods
    private fun at(): TokenTuple {
        return tokens[cursor]
    }
    private fun eatToken(tokenType: Tokens) {
        if (tokenType == at().first) {
            this.cursor++
        } else {
            throw InvalidToken("Invalid token type, expected: ${tokenType}, got: ${at().first}")
        }
    }
    private fun eatToken(tokenType: TokenTuple) {
        if (tokenType == at()) {
            this.cursor++
        } else {
            throw InvalidToken("Invalid token, expected: ${tokenType}, got: ${at()}")
        }
    }

    // Parsing Methods:

    // Addition and subtraction
    private fun parseExpression(): AstMember {
        var leftHandSide: AstMember = this.parseTerm()

        while (this.at() in additiveOperators) {
            val op = this.at()

            val operator = if (op == Pair(Tokens.OPERATOR, "+")) Operator.PLUS
            else Operator.MINUS

            this.eatToken(Tokens.OPERATOR)
            val rhs = this.parseTerm()
            leftHandSide = BinaryExpression(value = Operation(
                leftHandSide,
                operator,
                rhs
            ))
        }

        return leftHandSide
    }

    // Multiplication or division
    private fun parseTerm(): AstMember {
        var leftHandSide = this.parseIdentity()

        while (this.at() in multiplicativeOperators) {
            val operator = when (this.at()) {
                Pair(Tokens.OPERATOR, "*") -> Operator.TIMES
                Pair(Tokens.OPERATOR, "/") -> Operator.DIVIDE
                else -> Operator.MODULO
            }

            this.eatToken(Tokens.OPERATOR)
            val rhs = this.parseIdentity()
            leftHandSide = BinaryExpression(value = Operation(
                leftHandSide,
                operator,
                rhs
            ))
        }

        return leftHandSide
    }

    // parse powers
    private fun parseIdentity(): AstMember {
        var leftHandSide = this.parseFactor()

        while (this.at() == Pair(Tokens.OPERATOR, "^")) {
            val operator = Operator.POWER

            this.eatToken(Tokens.OPERATOR)
            val rhs = this.parseFactor()
            leftHandSide = BinaryExpression(value = Operation(
                leftHandSide,
                operator,
                rhs
            ))
        }

        return leftHandSide
    }

    // highest
    private fun parseFactor(): AstMember {

        return if (this.at().first == Tokens.COMPLEX_NUMBER) {
            val complexIndex = at().second.toInt()
            val number = numbers[complexIndex]
            val literal = NumericLiteral(value = number)
            this.eatToken(Tokens.COMPLEX_NUMBER)
            literal
        } else {
            val leftParenthesis = Pair(Tokens.STRUCTURE, "(")
            val rightParenthesis = Pair(Tokens.STRUCTURE, ")")

            val expression: AstMember
            if (this.at() == leftParenthesis) {
                this.eatToken(leftParenthesis)
                expression = this.parseExpression()
                this.eatToken(rightParenthesis)
                return expression
            } else if(this.at().first == Tokens.FUNCTION) {
                val function = Dictionaries.functionMap[this.at().second] as (ComplexNumber) -> ComplexNumber
                this.eatToken(Tokens.FUNCTION)
                this.eatToken(leftParenthesis)
                expression = this.parseExpression()
                this.eatToken(rightParenthesis)
                return FunctionExpression(value = Function(function, expression))
            }
            throw InvalidToken("Expected Left parenthesis token or number, instead received: ${this.at()}")
        }
    }

    fun parse(): AstMember {
        return parseExpression()
    }

}