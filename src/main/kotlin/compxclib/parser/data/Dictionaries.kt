package compxclib.parser.data

import compxclib.ComplexNumber
import compxclib.functions.*
import compxclib.parser.parsing.AstTree

/**
 * Contains useful dictionaries for the lexing process
 * @see compxclib.parser.lexing
 */
object Dictionaries {
    private fun nthrt(input: ComplexNumber): ComplexNumber {
        return nthrt(input, 1)
    }
    private fun ln(input: ComplexNumber): ComplexNumber {
        return compxclib.functions.ln(input)
    }

    private fun complexLog(input: ComplexNumber): ComplexNumber {
        return log(input, 10.toComplex())
    }

    private fun arcsin(input: ComplexNumber): ComplexNumber {return compxclib.functions.arcsin(input)}
    private fun arccos(input: ComplexNumber): ComplexNumber {return compxclib.functions.arccos(input)}
    private fun arctan(input: ComplexNumber): ComplexNumber {return compxclib.functions.arctan(input)}
    private fun arccot(input: ComplexNumber): ComplexNumber {return compxclib.functions.arccot(input)}
    private fun arcsec(input: ComplexNumber): ComplexNumber {return compxclib.functions.arcsec(input)}
    private fun arccsc(input: ComplexNumber): ComplexNumber {return compxclib.functions.arccsc(input)}

    private fun mag(input: ComplexNumber): ComplexNumber { return input.mag().toComplex() }
    private fun arg(input: ComplexNumber): ComplexNumber { return input.arg().toComplex() }

    /**
     * All the library's valid functions
     * @since Version 1.0
     */
    val functionAliases = arrayOf(
        "exp",
        "sqrt",
        "cbrt",
        "nthrt",
        "sinh",
        "cosh",
        "tanh",
        "coth",
        "sech",
        "csch",
        "ln",
        "log",
        "floor",
        "ceil",
        "sin",
        "cos",
        "tan",
        "cot",
        "sec",
        "csc",
        "arcsin",
        "arccos",
        "arctan",
        "arccot",
        "arcsec",
        "arccsc",
        "mag",
        "arg"
    )

    /**
     * All the library's valid functions that are usable within the parse
     * @since Version 1.0
     * @see compxclib.parser
     */
    private val functions = arrayOf<(ComplexNumber) -> ComplexNumber>(
        ::exp,
        ::sqrt,
        ::cbrt,
        this::nthrt,
        ::sinh,
        ::cosh,
        ::tanh,
        ::coth,
        ::sech,
        ::csch,
        this::ln,
        this::complexLog,
        ::floor,
        ::ceil,
        ::sin,
        ::cos,
        ::tan,
        ::cot,
        ::sec,
        ::csc,
        this::arcsin,
        this::arccos,
        this::arctan,
        this::arccot,
        this::arcsec,
        this::arccsc,
        this::mag,
        this::arg
    )

    /**
     * Dictionary used in the [AstTree] class to eventually evaluate an expression
     * @since Version 1.0
     * @see compxclib.parser.parsing
     */
    val functionMap = functionAliases.zip(functions).toMap()

}