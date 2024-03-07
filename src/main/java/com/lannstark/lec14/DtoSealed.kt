package com.lannstark.lec14

fun main() {
    handleCountry(Country.CHINA)
    handleCar(ACar())
    handleCar(BCar())
    handleCar(CCar())
}

// builder, toString, equals, hashCode
data class PersonDto(val name: String, val age: Int)

fun handleCountry(country: Country) {
    when (country) {
        Country.KOREA -> println(Country.KOREA)
        Country.UNITED_STATES -> println(Country.UNITED_STATES)
        Country.CHINA -> println(Country.CHINA)
    }
}
// enum class
enum class Country(private val code: String) {
    KOREA("KOR"),
    UNITED_STATES("US"),
    CHINA("CH")
    ;
}

fun handleCar(car: ClosedCar) {
    when (car) {
        is ACar -> println("A")
        is BCar -> println("B")
        is CCar -> println("C")
    }
}

// sealed
sealed class ClosedCar(val name: String, val price: Long)

class ACar : ClosedCar("acar", 2L)
class BCar : ClosedCar("bcar", 3L)
class CCar : ClosedCar("ccar", 4L)