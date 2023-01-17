package compxclib.parser

import compxclib.ComplexNumber
import compxclib.functions.*

object Dictionaries {
    private val complexLog: (ComplexNumber, ComplexNumber, Int) -> ComplexNumber = ::log

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
    private val functions = arrayOf(
        ::exp,
        ::sqrt,
        ::cbrt,
        ::nthrt,
        ::sinh,
        ::cosh,
        ::tanh,
        ::coth,
        ::sech,
        ::csch,
        ::ln,
        ::complexLog,
        ::floor,
        ::ceil,
        ::sin,
        ::cos,
        ::tan,
        ::cot,
        ::sec,
        ::csc,
        ::arcsin,
        ::arccos,
        ::arctan,
        ::arccot,
        ::arcsec,
        ::arccsc,
        ::mag,
        ::arg
    )

    val functionMap = functionAliases.zip(functions).toMap()

}