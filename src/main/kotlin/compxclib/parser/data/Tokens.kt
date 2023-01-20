package compxclib.parser.data

/**
 * Enum class that contains the token types used inside the lexing classes
 * @see compxclib.parser.lexing
 * @since Version 1.0
 */
enum class Tokens {
    OPERATOR,
    NUMBER,
    REAL_NUMBER,
    IMAGINARY_NUMBER,
    COMPLEX_NUMBER,
    IMAGINARY_UNIT,
    FUNCTION,
    STRUCTURE,
    EOF
}