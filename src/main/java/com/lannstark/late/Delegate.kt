package com.lannstark.late

fun main() {
    val person = Person()
    person.confirmKim
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