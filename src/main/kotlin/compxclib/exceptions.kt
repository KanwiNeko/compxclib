package compxclib

class IllegalConversionArgument(message: String): Exception(message)

class ConversionRangeOutsideOfBounds(message: String): Exception(message)

class InvalidComparison(message: String): Exception(message)