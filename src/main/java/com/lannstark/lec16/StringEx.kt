package com.lannstark.lec16

fun main() {
    println("777l".lastChar())
    println(Person("a", "b", 1).nextYearAge())
}

fun String.lastChar(): Char {
    return this[this.length - 1]
}

fun Person.nextYearAge() : Int {
    println("확장")
    return 1
}