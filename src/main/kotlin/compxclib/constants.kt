package compxclib

object Constants {

    fun i(): CNumber {
        return CNumber(0,1)
    }

    private var defaultRound: Int = 13
    @Suppress("unused")
    fun setDefaultRound(value: Int) {
        if (value in 0..13) {
            this.defaultRound = value
        } else {
            throw ConversionRangeOutsideOfBounds("The conversion number passed is outside the range")
        }
    }
    fun getDefaultRound(): Int {
        return this.defaultRound
    }

}