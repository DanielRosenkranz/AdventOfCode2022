package nl.roseit.adventofcode2022

import java.io.File

object Day3 {

    val input: List<String> = File("src/main/resources", "day3.txt")
        .readLines()

    val itemValueString = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

    fun shared(logic: (List<String>) -> List<Set<Char>>): Int {
        return logic.invoke(input)
            .map { itemValueString.indexOf(it.first()) }
            .sum()
    }

    fun getResultPart1(): Int {
        return shared {
            it.map { it.chunked(it.length / 2) }
                .map { it[0].toSet().intersect(it[1].toSet()) }
        }

    }

    fun getResultPart2(): Int {
        return shared {
            it.chunked(3)
                .map { it[0].toSet().intersect(it[1].toSet()).intersect(it[2].toSet()) }
        }

    }

}
