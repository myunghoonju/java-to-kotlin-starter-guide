package com.lannstark

// 구조분해 문법
// data provides componentN
data class Person (val name: String, val age: Int)

class Person2 (val name: String, val age: Int) {
   operator fun component1(): String {
       return this.name
   }

   operator fun component2(): Int {
       return this.age
   }
}

fun main() {
    val (name, age) = Person("a", 10)
    println("${name}, ${age}")

    val (name2, age2) = Person2("a", 10)
    println("${name2}, ${age2}")

    val numbers = listOf(1, 2, 3)
    numbers.map { num -> num + 1 }.forEach { num -> println(num) }
}