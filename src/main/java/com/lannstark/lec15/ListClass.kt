package com.lannstark.lec15

fun main() {
    val array = arrayOf(1, 2, 3, 4) // new Integer[]{1, 2, 3, 4};
    val array2 = listOf(1, 2, 3, 4) // read-only list
    val array3 = mutableListOf(1, 2, 3, 4)

    println(array[0])

    for (num in array) {
        println(num)
    }

    for (i in array.indices) { // idx
        print("${array[i]}")
    }
    println()
    println("---------------------")

    for ((i, value) in array.withIndex()) { // idx, val
        print("${i} \n ${value}")
    }

    printNumbers(emptyList())
}

private fun printNumbers(number: List<Int>) {

}