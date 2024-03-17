package com.lannstark

fun main() {
    printPerson(Person("AA", 1))
}

fun printPerson(person: Person?) {
    person?.let {
        println(it.name) // or p.name
        println(it.age) // or p.age
    }

    person?.run {
        println(this.age) // or age
    }

    val person1 = Person("a", 1)
    with(person1) {
        println(this.age) // or age
    }

    person?.apply {
        print(this.age)
    }
}