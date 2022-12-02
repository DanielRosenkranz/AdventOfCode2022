package nl.roseit.adventofcode2022

import java.io.File

object Day1 {

    fun shared(): List<Int> {
        val input: List<String> = File("src/main/resources", "day1.txt")
            .readLines()
        var i = 0
        val arr = Array(input.count { it.isEmpty() } + 1  ) { 0 }
        input.forEach {
            if(it.isEmpty()) i++ else arr[i] += it.toInt()
        }
        return arr.toList()
    }

    fun getResultPart1(): Int {
        return shared().max()
    }

    fun getResultPart2(): Int {
        return shared().sorted().takeLast(3).sum()
    }


}
