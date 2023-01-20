package compxclib.enums

/**
 * Enum used for inverse trigonometric functions inside [compxclib.functions]
 *
 * The **inverse trigonometric formulas** for Complex Numbers often include a
 * square root with a plus minus operator.
 *
 * This means that the formula has 2 different square root branches, this enum is
 * used to pick a branch
 * @since Version 1.0
 * @see [compxclib.ComplexNumber]
 * @see [compxclib.functions]
 */
enum class SqrtBranch {
    POSITIVE, NEGATIVE
}

/**
 * Enum used inside [compxclib.ComplexNumber] to overload the [compxclib.ComplexNumber.inc]
 * and [compxclib.ComplexNumber.dec] operators.
 *
 * The `inc` and `dec` methods inside [compxclib.ComplexNumber] can be called as an operator, and they
 * will assume the parameter is [BOTH], otherwise it can be called as a function and specify which
 * kind of parameter you wish to increment or decrease
 * @since Version 1.0
 * @see [compxclib.ComplexNumber]
 */
enum class Parameter {
    REAL, IMAGINARY, BOTH
}

/**
 * Enum class used by [compxclib.parser.NumberLexer] to make **compiler safe `when` statements**
 * @since Version 1.0
 * @see [compxclib.parser.Parser]
 */
enum class Sign {
    POSITIVE, NEGATIVE
}

/**
 * Enum class used by [compxclib.parser.AstTree], [compxclib.parser.AstMember] and [compxclib.parser.Evaluator]
 * @since Version 1.0
 * @see [compxclib.parser.Parser]
 */
enum class Operator {
    PLUS,
    MINUS,
    TIMES,
    DIVIDE,
    MODULO,
    POWER
}