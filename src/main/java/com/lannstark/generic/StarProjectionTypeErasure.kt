package com.lannstark.generic

fun main() {
    val i = 3
    i.toSuperStr2()

    val s = "A"
    // println("${s::class.java.name}: $s") -> ok!
    s.toSuperStr2()
}

fun check(data: Any) {
    if (data is List<*>) {
        val el: Any? = data[0]
        // data.add(3) -> error!
    }
}

fun <T> T.toSuperStr() {
    // T::class 클래스 정보 가져오는 코드
    // 런타임에 T의 타입을 알 수 없어 에러
    // println("${T::class.java.name}: $this")
}

inline fun <reified T> T.toSuperStr2() {
    // T::class 클래스 정보 가져오는 코드
    // 런타임에 T의 타입을 알 수 없어 에러
    println("${T::class.java.name}: $this")
}