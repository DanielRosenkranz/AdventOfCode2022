package nl.roseit.adventofcode2022

import java.io.File

object Day4 {

    val input: List<String> = File("src/main/resources", "day4.txt")
        .readLines()

    fun shared(): List<List<IntRange>> {
        return input.map { it.split(',') }
            .map {
                it.map {
                    val splitted = it.split('-')
                    (splitted[0].toInt()..splitted[1].toInt())
                }
            }
    }

    fun getResultPart1(): Int {
        return shared()
            .filter {
                (it[0].first >= it[1].first && it[0].last <= it[1].last) ||
                        (it[1].first >= it[0].first && it[1].last <= it[0].last)
            }
            .count()
    }

    fun getResultPart2(): Int {
        return shared()
            .filter {
                it[0].intersect(it[1]).isNotEmpty()
            }
            .count()
    }

}
