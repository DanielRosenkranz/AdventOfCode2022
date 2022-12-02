package nl.roseit.adventofcode2022

import java.io.File

object Day2 {

    fun getResultPart1(): Int {
        val input: List<String> = File("src/main/resources", "day2.txt")
            .readLines()

        return input.map {
            val (opponent, you) = it.split(' ')
                .map { it.toMove() }
                .take(2)

            val determineOutcome = when {
                you == Move.ROCK && opponent == Move.SCISSORS -> Outcome.WIN
                you == Move.PAPER && opponent == Move.ROCK -> Outcome.WIN
                you == Move.SCISSORS && opponent == Move.PAPER -> Outcome.WIN
                you == opponent -> Outcome.DRAW
                else -> Outcome.LOSE
            }

            calculateValue(determineOutcome, you)
        }.sum()
    }

    fun getResultPart2(): Int {
        val input: List<String> = File("src/main/resources", "day2.txt")
            .readLines()

        return input.map {
            val (opponent, you) = it.split(' ')
                .take(2)

            val neededOutcome = when (you) {
                "X" -> Outcome.LOSE
                "Y" -> Outcome.DRAW
                "Z"-> Outcome.WIN
                else -> throw IllegalStateException("Could not transform $this to Putcome")
            }

            val correctMove: Move = when (neededOutcome) {
                Outcome.WIN -> whatMoveIsNeededToWin(opponent.toMove())
                Outcome.LOSE -> whatMoveIsNeededToLose(opponent.toMove())
                Outcome.DRAW -> opponent.toMove()
            }

            calculateValue(neededOutcome, correctMove)
        }.sum()
    }

    private fun calculateValue(outcome: Outcome, chosenMove: Move): Int {
        val outcomeValue = when (outcome) {
            Outcome.WIN -> 6
            Outcome.LOSE -> 0
            Outcome.DRAW -> 3
        }

        val moveValue = when (chosenMove) {
            Move.ROCK -> 1
            Move.PAPER -> 2
            Move.SCISSORS -> 3
        }

        return outcomeValue + moveValue
    }

    private fun String.toMove(): Move = when (this) {
        "A", "X" -> Move.ROCK
        "B", "Y" -> Move.PAPER
        "C", "Z" -> Move.SCISSORS
        else -> throw IllegalStateException("Could not transform $this to Move")
    }

    private fun whatMoveIsNeededToWin(opponentMove: Move): Move = when (opponentMove) {
        Move.ROCK -> Move.PAPER
        Move.PAPER -> Move.SCISSORS
        Move.SCISSORS -> Move.ROCK
    }

    private fun whatMoveIsNeededToLose(opponentMove: Move): Move = when (opponentMove) {
        Move.ROCK -> Move.SCISSORS
        Move.PAPER -> Move.ROCK
        Move.SCISSORS -> Move.PAPER
    }

    private enum class Move {
        ROCK, PAPER, SCISSORS
    }

    private enum class Outcome {
        WIN, DRAW, LOSE
    }

}
