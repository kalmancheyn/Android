package com.example.calculator

import org.junit.Test

import org.junit.Assert.*

class CalculatorTest {

    @Test
    fun calculate() {
        @Test
        fun statementWithOneOperatorShouldEqualItself(){
            //given
            val calculator = Calculator()
            val expected = "15"
            val statement = "15"
            //when
            val actual = calculator.calculate(statement)
            //then
            assertEquals(expected, actual)
        }

        fun negativeStatementShouldResultInPositiveValue(){
            //given
            val calculator = Calculator()
            val expected = "5"
            val statement = "5-10"
            //when
            val actual = calculator.calculate(statement)
            //then
            assertEquals(expected, actual)
        }

        fun statementWithTwoOperatorsShouldFail(){
            //given
            val calculator = Calculator()
            val expected = "5"
            val statement = "5-10"
            //when
            val actual = calculator.calculate(statement)
            //then
            assertEquals(expected, actual)
        }

    }
}