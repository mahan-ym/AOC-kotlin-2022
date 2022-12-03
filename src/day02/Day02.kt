package day02

import readInput

fun main() {
    //    A -> Rock, B -> Paper, C -> Scissors
    //    X -> Rock, Y -> Paper, Z -> Scissors
    //    you get 6 scores when you win, 3 scores when you draw and Rock = 1, Paper = 2, Scissors = 3 scores

    fun getFullScore(input: List<String>):Int {
        var score = 0
        input.forEach { record ->
            score += record.getCombinationScore()
            score += record.split(" ")[1].getPlayedElementScore()
        }
        return score
    }

    val testInput = readInput("Day02_test")
    check(getFullScore(testInput) == 15)

    val input = readInput("Day02")
    println(getFullScore(input))
}

fun String.getPlayedElementScore(): Int =
    if (this == "X") 1
    else if(this == "Y") 2
    else 3

fun String.getCombinationScore(): Int =
    if (this == "A Y" || this == "B Z" || this == "C X") 6
    else if(this == "A X" || this == "B Y" || this == "C Z") 3
    else 0