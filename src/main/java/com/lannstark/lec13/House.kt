package com.lannstark.lec13

fun main() {
    val livingRoom = House.LivingRoom(1.0)
    println(livingRoom.area)
}

class House(private  val address: String,
            private val livingRoom: LivingRoom) {

    class LivingRoom(val area: Double)
}

class House2(private  val address: String,
             private val livingRoom: LivingRoom) {

    inner class LivingRoom(private val are: Double) {
        val address: String
            get() = this@House2.address
    }
}