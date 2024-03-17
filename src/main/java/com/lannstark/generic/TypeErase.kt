package com.lannstark.generic

fun main() {
    val cageShadow = CageShadow0<GoldFish>()
    cageShadow.add0(GoldFish("A"))
    cageShadow.add0(Carp("C"))
}

open class CageShadow0<T : Animal> {
    open fun <T : Animal> add0(animal: T) {

    }
}
open class CageShadow<T : Animal> {
    open fun add1(animal: T) {

    }
}

class CageV1<T : Animal> : CageShadow<T>() {
    override fun add1(animal: T) {
        super.add1(animal)
    }
}

class CageV2 : CageShadow<GoldFish>() {}


class CageV3 : CageShadow<GoldFish>() {
    override fun add1(animal: GoldFish) {
        super.add1(animal)
    }
}
