package compxclib.parser.data

/**
 * Enum class used for compiler safe check in the [Evaluator] class
 * @since Version 1.0
 * @see [Evaluator]
 * @see [AstMember]
 */
enum class AstTypes {
    NUMERIC_LITERAL,
    BINARY_OPERATOR,
    FUNCTION
}