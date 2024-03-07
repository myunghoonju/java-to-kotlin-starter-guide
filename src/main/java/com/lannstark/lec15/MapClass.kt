package com.lannstark.lec15

fun main() {
    val map = mutableMapOf<Int, String>()
    map[0] = "T"
    map[1] = "U"

    // read-only map
    val mapOf = mapOf(1 to "Mon", 2 to "Tue")

    for (key in map.keys) {
        println("${key}, ${map[key]}")
    }

    for ((k, v) in map.entries) {
        println("${k}, ${v}")
    }
}