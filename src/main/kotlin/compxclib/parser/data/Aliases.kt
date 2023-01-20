package compxclib.parser.data

/**
 * Member type of the Lists passed to the lexing classes
 * @see compxclib.parser.lexing
 */
typealias TokenTuple = Pair<Tokens, String>
/**
 * type of the Lists passed to the lexing classes
 * @see compxclib.parser.lexing
 */
typealias ComplexList = List<TokenTuple>
/**
 * Member type of the Lists used inside the lexing classes
 * @see compxclib.parser.lexing
 */
typealias MutableComplexList = MutableList<TokenTuple>
