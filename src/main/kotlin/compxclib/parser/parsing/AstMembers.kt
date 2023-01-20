package compxclib.parser.parsing

import compxclib.ComplexNumber
import compxclib.enums.Operator
import compxclib.parser.data.AstTypes

/**
 * Numeric Literal type of the kind [AstMember]
 *
 * This member of the AST tree stores a number
 * @property type: by default is [AstTypes.NUMERIC_LITERAL]
 * @property value: the [ComplexNumber] that it stores
 * @since Version 1.0
 * @see AstMember
 * @see ComplexNumber
 * @see AstTypes
 */
data class NumericLiteral(
    override val type: AstTypes = AstTypes.NUMERIC_LITERAL,
    override val value: ComplexNumber) : AstMember

/**
 * Binary Expression type of the kind [AstMember]
 *
 * This member of the AST tree stores an [Operation]
 * @property type: by default is [AstTypes.BINARY_OPERATOR]
 * @property value: the [ComplexNumber] that it stores
 * @since Version 1.0
 * @see AstMember
 * @see Operation
 * @see AstTypes
 */
data class BinaryExpression (
    override val type: AstTypes = AstTypes.BINARY_OPERATOR,
    override val value: Operation
) : AstMember

/**
 * Function Expression type of the kind [AstMember]
 *
 * This member of the AST tree stores a [Function]
 * @property type: by default is [AstTypes.FUNCTION]
 * @property value: the [ComplexNumber] that it stores
 * @since Version 1.0
 * @see AstMember
 * @see Function
 * @see AstTypes
 */
data class FunctionExpression (
    override val type: AstTypes = AstTypes.FUNCTION,
    override val value: Function
) : AstMember

/**
 * Operation class that holds the information of a [BinaryExpression]
 *
 * Operation contains the components of a binary operation:
 * `Left hand side, operator, Right hand side`
 * @property leftHandSide an [AstMember]
 * @property rightHandSide an [AstMember]
 * @property operator an [Operator]
 * @since Version 1.0
 * @see AstMember
 * @see BinaryExpression
 * @see Operator
 */
data class Operation (
    val leftHandSide: AstMember,
    val operator: Operator,
    val rightHandSide: AstMember
)

/**
 * Function class that holds the information of a [FunctionExpression]
 *
 * Operation contains the components of a function:
 * `Function type, Inside`
 * @property function an `(ComplexNumber) -> ComplexNumber`
 * @property inside an [AstMember]
 * @since Version 1.0
 * @see AstMember
 * @see FunctionExpression
 * @see ComplexNumber
 */
data class Function(
    val function: (ComplexNumber) -> ComplexNumber,
    val inside: AstMember
)