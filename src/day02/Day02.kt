package day02

import readInput

fun main() {
    fun createParsedDataFromInput(filePath: String): List<Pair<String, Int>> {
        val inputString = readInput(filePath)

        val parsedInput:MutableList<Pair<String, Int>> = mutableListOf()

        inputString.forEach {
            parsedInput.add(it.substringBefore(" ") to it.substringAfter(" ").toInt())
        }

        return parsedInput
    }

    fun solveTask01(): Int {
        val input = createParsedDataFromInput("day02/input")

        var depth = 0
        var distance = 0

        input.forEach {
            when (it.first) {
                "forward" -> distance += it.second
                "down" -> depth += it.second
                "up" -> depth -= it.second
            }
        }

//        println("Depth: $depth")
//        println("Distance: $distance")

        return depth * distance

    }

    fun solveTask02(): Int {
        val input = createParsedDataFromInput("day02/input")
        var aim = 0
        var distance = 0
        var depth = 0

        input.forEach {
            when (it.first) {
                "forward" -> {
                    distance += it.second
                    depth += aim * it.second
                }
                "down" -> aim += it.second
                "up" -> aim -= it.second
            }
        }

        return depth * distance
    }

    println("Result for task 1: ${solveTask01()}")
    println("Result for task 2: ${solveTask02()}")
}