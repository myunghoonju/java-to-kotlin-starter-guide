package com.lannstark.lec17

import com.lannstark.lec17.b.hello as helloB
import com.lannstark.lec17.a.hello as helloA

fun main() {
    var fruits = listOf(Fruit("apple", 1_000),
                        Fruit("banana", 2_000),
                        Fruit("strawberry", 3_000),
                        Fruit("blueberry", 4_000))

    val isApple = fun(fruit: Fruit): Boolean {
        return fruit.name == "apple"
    }

    val isApple2 = { fruit: Fruit -> fruit.name == "apple" }

    isApple(fruits[0])
    isApple.invoke(fruits[0])

    filter(fruits, isApple)
    filter(fruits, isApple2)

    // same
    filter(fruits, { fruit: Fruit -> fruit.name == "apple" })
    filter(fruits) { fruit: Fruit -> fruit.name == "apple" }
    filter(fruits) { it.name == "apple" }

    // as import
    helloA()
    helloB()
}

private fun filter(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
    var res = mutableListOf<Fruit>()
    for (f in fruits) {
        if (filter(f)) {
            res.add(f)
        }
    }

    return res
}

typealias FruitFilter = (Fruit) -> Boolean

private fun filter2(fruits: List<Fruit>, filter: FruitFilter): List<Fruit> {
    var res = mutableListOf<Fruit>()
    fruits.filter(filter)
    fruits.all(filter)
    fruits.none(filter)
    fruits.any(filter)
    fruits.count()
    fruits.sortedBy { it.name }
    fruits.sortedByDescending { it.name }
    fruits.distinct()
    fruits.distinctBy { it.name }.map { it.name }
    fruits.first()
    fruits.last()
    fruits.firstOrNull()
    fruits.lastOrNull()
    val groupBy: Map<String, List<Fruit>> = fruits.groupBy { it.name }
    val associateBy: Map<String, Fruit> = fruits.associateBy { it.name }

    return res
}