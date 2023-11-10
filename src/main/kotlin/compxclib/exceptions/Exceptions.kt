package compxclib.exceptions

/**
 * Exception class used by [compxclib.ComplexNumber.toReal] when its imaginary part
 * is a non-zero value
 * @constructor Creates an [Exception] with the message [message]
 * @param [message] message thrown along the [Exception]
 * @see [compxclib.ComplexNumber]
 */
@Deprecated("This is unused")
class IllegalConversionArgument(message: String): Exception(message)

/**
 * Exception class used by [compxclib.Constants.setDefaultRound] and thrown if the [Int] value is
 * not between the range `0 .. 15`
 * @constructor Creates an [Exception] with the message [message]
 * @param [message] message thrown along the [Exception]
 * @see [compxclib.Constants]
 * @see [compxclib.Constants.setDefaultRound]
 */
class ConversionRangeOutsideOfBounds(message: String): Exception(message)

/**
 * Exception class used by [compxclib.ComplexNumber.checkEquals] when the parameter
 * provided is not of the type [compxclib.ComplexNumber] nor [Number]
 * @constructor Creates an [Exception] with the message [message]
 * @param [message] message thrown along the [Exception]
 * @see [compxclib.ComplexNumber]
 * @see [compxclib.ComplexNumber.checkEquals]
 */
class InvalidComparison(message: String): Exception(message)

/**
 * Exception class used by [compxclib.parser.AstTree] and [compxclib.parser.Lexer] that's
 * thrown everytime an unexpected token pops up either in the first lexing process or the
 * Abstract syntax tree creator.
 * @constructor Creates an [Exception] with the message [message]
 * @param [message] message thrown along the [Exception]
 * @see [compxclib.parser.Parser]
 * @see [compxclib.parser.Lexer]
 * @see [compxclib.parser.AstTree]
 */
class InvalidToken(message: String): Exception(message)