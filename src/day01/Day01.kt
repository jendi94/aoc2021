package day01

import readInput

fun main() {
    fun solveTask02(): Int {
        var list = readInput("day01/input").map { it.toInt() }
        var before: Int? = null
        var counter = 0

        if (list.size > 2) {
            before = list[0] + list[1] + list[2]
            list = list.drop(1)
        }

        while (list.size > 2) {
            val current = list[0] + list [1] + list[2]
            if (current > before!!) {
                counter++
            }
            before = current
            list = list.drop(1)
        }

        return counter
    }

    println("Result for task 2: ${solveTask02()}")
}
