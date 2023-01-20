package compxclib.parser.parsing

import compxclib.parser.data.AstTypes

/**
 * Interface used to declare the members of the [AstTree]
 * @property type the type of member
 * @property value the inside value of the member
 * @since Version 1.0
 * @see AstTree
 */
interface AstMember {
    val type: AstTypes
    val value: Any
}