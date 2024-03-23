package com.lannstark.late

import kotlin.properties.Delegates

fun main() {
    val person5 = Person5()
    val person6 = Person6()

    person5.age = 30
    println(person5.age)
    person5.age = 0
    println(person5.age)

    person6.num = 10
    println(person6.num)
    println(person6.age)
}

class Person {
    private lateinit var name: String

    val confirmKim: Boolean
        get() = this.name.startsWith("Kim")

    val maskedName: String
        get() = name[0] + (1 until name.length).joinToString("") { "*" }
}

// backing property _name <- coding convention
class PersonTwo {
    private var _name: String? = null

    val name: String
        get() {
            if (_name == null) {
                Thread.sleep(2_000L)
                this._name = "Kim"
            }

            return this._name!!
        }
}

// by lazy instead of backing property
// it's thread-safe
class PersonThree {
    val name: String by lazy {
        Thread.sleep(2_000L)
        "Kim"
    }
}

class Person4 {
    var age: Int by Delegates.observable(20) { _, oldValue, newValue ->
        if (oldValue != newValue) {
            println("before ${oldValue} after : ${newValue}")
        }
    }
}

class Person5 {
    var age: Int by Delegates.vetoable(20) { _, _, newValue -> newValue >= 1}
}

class Person6 {
    @Deprecated("use age", ReplaceWith("age"))
    var num: Int = 0

    var age: Int by this::num
}

