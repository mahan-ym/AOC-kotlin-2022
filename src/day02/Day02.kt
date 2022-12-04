package day02

import readInput

fun main() {
    //    A -> Rock, B -> Paper, C -> Scissors
    //    X -> Rock, Y -> Paper, Z -> Scissors
    //    you get 6 scores when you win, 3 scores when you draw and Rock = 1, Paper = 2, Scissors = 3 scores
    //    second part: X -> need to lose, Y -> need to draw, Z -> need to win

    fun getFullScore(input: List<String>):Int {
        var score = 0
        input.forEach { record ->
            score += record.getCombinationScore()
            score += record.split(" ")[1].getPlayedElementScore()
        }
        return score
    }

    fun getFullScorePhase2(input: List<String>):Int {
        var score = 0
        input.forEach { record ->
            score += record.split(" ")[1].getScorePhase2()
            score += getPlayedElementScorePhase2(record.split(" ")[0], record.split(" ")[1])
        }
        return score
    }

    val testInput = readInput("Day02_test")
    check(getFullScore(testInput) == 15)
    check(getFullScorePhase2(testInput) == 12)

    val input = readInput("Day02")
    println(getFullScore(input))
    println(getFullScorePhase2(input))
}

fun String.getPlayedElementScore(): Int =
    if (this == "X") 1
    else if(this == "Y") 2
    else 3

fun String.getCombinationScore(): Int =
    if (this == "A Y" || this == "B Z" || this == "C X") 6
    else if(this == "A X" || this == "B Y" || this == "C Z") 3
    else 0

fun String.getScorePhase2(): Int =
    if (this == "Z") 6
    else if(this == "Y") 3
    else 0

fun getPlayedElementScorePhase2(played: String, status: String): Int {
    return when(status) {
        "X" -> {
            lose(played)
        }
        "Y" -> {
            draw(played)
        }
        else -> {
            win(played)
        }
    }
}

fun lose(played: String): Int {
    return when(played) {
        "A" -> 3
        "B" -> 1
        else -> 2
    }
}

fun win(played: String): Int {
    return when(played) {
        "A" -> 2
        "B" -> 3
        else -> 1
    }
}

fun draw(played: String): Int {
    return when(played) {
        "A" -> 1
        "B" -> 2
        else -> 3
    }
}
