package compxclib.parser.parsing

import compxclib.ComplexNumber
import compxclib.enums.Operator
import compxclib.parser.data.AstTypes

/**
 * This class represents the very last step in the parsing process, it receives in its
 * constructor an [AstMember] Tree, and it evaluates it its only public main method.
 * @param input the [AstMember] Tree
 * @since Version 1.0
 * @see AstMember
 * @see compxclib.parser.lexing
 */
class Evaluator(private val input: AstMember) {

    /**
     * **Only** public method of the class, evaluates an [AstMember] Tree and returns
     * a [ComplexNumber] value
     * @return a parsed [ComplexNumber]
     * @since Version 1.0
     * @see compxclib.parser.lexing
     * @see AstMember
     */
    fun evaluate(): ComplexNumber {
        val evaluatedExpression = evaluateExpression(this.input)
        return evaluateNumericLiteral(evaluatedExpression)
    }

    private fun evaluateNumericLiteral(input: NumericLiteral): ComplexNumber {
        return input.value
    }

    private fun evaluateExpression(input: AstMember): NumericLiteral {
        return when(input.type) {
            AstTypes.FUNCTION -> evaluateFunctionExpression(input as FunctionExpression)
            AstTypes.BINARY_OPERATOR -> evaluateBinaryExpression(input as BinaryExpression)
            AstTypes.NUMERIC_LITERAL -> input as NumericLiteral
        }
    }

    private fun evaluateBinaryExpression(input: BinaryExpression): NumericLiteral {
        val value = input.value
        val lhs = evaluateExpression(value.leftHandSide).value
        val rhs = evaluateExpression(value.rightHandSide).value
        return NumericLiteral(value = when(value.operator){
            Operator.PLUS -> lhs + rhs
            Operator.MINUS -> lhs - rhs
            Operator.TIMES -> lhs * rhs
            Operator.DIVIDE -> lhs / rhs
            Operator.MODULO -> lhs % rhs
            Operator.POWER -> lhs.pow(rhs)
        })
    }

    private fun evaluateFunctionExpression(input: FunctionExpression): NumericLiteral {
        val inside = input.value.inside
        val function = input.value.function
        val evaluatedInside = evaluateExpression(inside)
        val evaluatedNumber = evaluatedInside.value
        val result = function.invoke(evaluatedNumber)
        return NumericLiteral(value = result)
    }
}