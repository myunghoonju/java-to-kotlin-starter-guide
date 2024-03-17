package com.lannstark.generic

// effective java item 28
fun main() {
    val cage = Cage()
    cage.put(Carp("Tom"))
    // val tom: Carp = cage.first() as? Carp?: throw IllegalArgumentException() // still can cause exception
    // val tom: Carp = cage.first() as Carp // (Carp) cage.first()

    // no need of type casting
    val cageTwo = CageTwo<Carp>()
    cageTwo.put(Carp("Sam"))
    val sam: Carp = cageTwo.first()

    // val goldFishInCageTwo = CageTwo<GoldFish?>() // error, null not allowed
    val goldFishInCageTwo = CageTwo<GoldFish>()
    goldFishInCageTwo.put(GoldFish("Sara"))

// Collections.kt 참고
//    no relevance...
//    Required: CageTwo<Fish>
//    Found: CageTwo<GoldFish>
    val cageThree = CageTwo<Fish>()
    // co-variant
    cageThree.move(goldFishInCageTwo)

    val cageTwo1 = CageTwo<Fish>()
    val goldFishCageTwo = CageTwo<GoldFish>()
    goldFishCageTwo.put(GoldFish("V"))
    // contra-variant
    goldFishCageTwo.move2(cageTwo1) // GoldFish -> Fish, CageTwo<Fish>() -> CageTwo<GoldFish>()

    val fishCage: CageThree<Fish> = CageThree()
    val animalCage: CageThree<Animal> = fishCage

    val cageFive = CageFive(mutableListOf(Eagle(), Sparrow()))
    cageFive.sort()
}

class Cage {
    private val animals: MutableList<Animal> = mutableListOf()

    fun first(): Animal {
        return animals.first()
    }

    fun put(animal: Animal) {
        this.animals.first()
    }

    fun move(cage: Cage) {
        this.animals.addAll(cage.animals)
    }
}

// generic class + non-null
class CageTwo<T : Any> {
    private val animals: MutableList<T> = mutableListOf() // MutableList<E>

    fun first(): T {
        return animals.first()
    }

    fun put(animal: T) {
        this.animals.first()
    }

    fun move(cage: CageTwo<out T>) { // give covariance, only produce
        this.animals.addAll(cage.animals)
    }

    fun move2(cage: CageTwo<in T>) { // give contra-variant only consume
        cage.animals.addAll(this.animals)
    }
}

// only produce data
class CageThree<out T> {
    private val animals: MutableList<T> = mutableListOf() // MutableList<E>

    fun first(): T {
        return animals.first()
    }

    fun animals(): List<T> {
        return animals
    }
}

// only consume data
class CageFour<in T> {
    private val animals: MutableList<T> = mutableListOf() // MutableList<E>

    fun put(animal: T) {
        animals.add(animal)
    }

    fun putAll(animals: List<T>) {
        this.animals.addAll(animals)
    }
}

//class CageFive<T : Animal> (
//    private val animals: MutableList<T> = mutableListOf()
//) {}

abstract class Bird(
    name : String,
    private val size: Int,
) : Animal(name), Comparable<Bird> {
    override fun compareTo(other: Bird): Int {
        return this.size.compareTo(other.size)
    }
}

class Sparrow : Bird("S", 100)
class Eagle : Bird("E", 200)

class CageFive<T>(
    private val animals: MutableList<T> = mutableListOf()
) where T : Animal, T : Comparable<T> { // declared order

    fun sort() {
        this.animals.sorted().map { it.name }.let { println(it) }
    }

    fun first(): T {
        return animals.first()
    }

    fun put(animal: T) {
        animals.add(animal)
    }

    fun move(cage: CageFive<T>) { // give covariance, only produce
        this.animals.addAll(cage.animals)
    }

    fun move2(cage: CageFive<T>) { // give contra-variant only consume
        cage.animals.addAll(this.animals)
    }
}
