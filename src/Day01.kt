fun main() {
    fun getElfWithMostCal(input: List<String>): Pair<Int,Int> {
        var recordIndex = 0
        val summedCals = arrayListOf<Int>()

        input.forEachIndexed { index ,record ->
            if (record == "") {
                summedCals.add(input.subList(recordIndex,index).sumOf { it.toInt() })
                recordIndex = index + 1
            }
        }
        if (recordIndex == input.size - 1 || recordIndex < input.size - 1)
            summedCals.add(input.subList(recordIndex,input.size).sumOf { it.toInt() })

        return summedCals.indexOf(summedCals.max()) + 1 to summedCals.max()
    }

    val testInput = readInput("Day01_test")
    check(getElfWithMostCal(testInput).first == 4)

    val input = readInput("Day01")
    val result = getElfWithMostCal(input)
    println("${result.first} with ${result.second} calories ")
}
