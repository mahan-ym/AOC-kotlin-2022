package day01

import readInput

fun main() {
    fun getEachElfWithMostCal(input: List<String>): ArrayList<Int> {
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
        return summedCals
    }

    fun getElfWithMostCal(input: List<String>): Pair<Int,Int> {
        val summedCals = getEachElfWithMostCal(input)
        return summedCals.indexOf(summedCals.max()) + 1 to summedCals.max()
    }

    fun getTopThreeElvesWithMostCalSum(input: List<String>): Int {
        val summedCals = getEachElfWithMostCal(input)
        summedCals.sortDescending()
        return summedCals[0] + summedCals[1] +  summedCals[2]
    }

    val testInput = readInput("Day01_test")
    check(getElfWithMostCal(testInput).first == 4)
    check(getTopThreeElvesWithMostCalSum(testInput) == 45000)

    val input = readInput("day01")
    val elfWithMostCal = getElfWithMostCal(input)
    println("${elfWithMostCal.first} with ${elfWithMostCal.second} calories ")
    val topThreeElvesWithMostCal = getTopThreeElvesWithMostCalSum(input)
    println(topThreeElvesWithMostCal)
}
