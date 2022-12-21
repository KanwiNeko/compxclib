package compxclib.parser

import compxclib.ComplexNumber
import compxclib.functions.*

object Dictionaries {
    private val complexLog: (ComplexNumber, ComplexNumber, Int) -> ComplexNumber = ::log

    val complexMethods: Map<String, Function<ComplexNumber>> = mapOf(
        //exponential
        "exp" to ::exp,
        "sqrt" to ::sqrt,
        "cbrt" to ::cbrt,
        "nthrt" to ::nthrt,

        //hyperbolic
        "sinh" to ::sinh,
        "cosh" to ::cosh,
        "tanh" to ::tanh,
        "coth" to ::coth,
        "sech" to ::sech,
        "csch" to ::csch,

        //logarithmic
        "ln" to ::ln,
        "log" to complexLog,

        //misc
        "floor" to ::floor,
        "ceil" to ::ceil,

        //trigonometric
        "sin" to ::sin,
        "cos" to ::cos,
        "tan" to ::tan,
        "cot" to ::cot,
        "sec" to ::sec,
        "csc" to ::csc,

        "arcsin" to ::arcsin,
        "arccos" to ::arccos,
        "arctan" to ::arctan,
        "arccot" to ::arccot,
        "arcsec" to ::arcsec,
        "arccsc" to ::arccsc
    )
    val realMethods: Map<String, Function<Number>> = mapOf(
        "mag" to ::mag,
        "arg" to ::arg
    )
}