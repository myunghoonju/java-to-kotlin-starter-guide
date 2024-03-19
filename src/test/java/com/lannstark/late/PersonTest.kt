package com.lannstark.late

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun kim() {
        val person = Person("KimMunSu")
        assertTrue(person.confirmKim)
    }

    @Test
    fun masked() {
        val person = Person("KimMunSu")
        assertEquals("K*******", person.maskedName)
    }
}