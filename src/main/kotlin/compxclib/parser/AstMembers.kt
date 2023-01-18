package compxclib.parser

import compxclib.ComplexNumber
import compxclib.Operator

data class NumericLiteral(
    override val type: AstTypes = AstTypes.NUMERIC_LITERAL,
    override val value: ComplexNumber) : AstMember

data class BinaryExpression (
    override val type: AstTypes = AstTypes.BINARY_OPERATOR,
    override val value: Operation ) : AstMember

data class FunctionExpression (
    override val type: AstTypes = AstTypes.FUNCTION,
    override val value: Function
) : AstMember

data class Operation (
    val leftHandSide: AstMember,
    val operator: Operator,
    val rightHandSide: AstMember
)

data class Function(
    val function: (ComplexNumber) -> ComplexNumber,
    val inside: AstMember
)