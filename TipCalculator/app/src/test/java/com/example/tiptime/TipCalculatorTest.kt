package com.example.tiptime
import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

// test directory is for local (unit) tests

class TipCalculatorTest {
    @Test
    fun calculateTip_20PercentNoRoundup() {
        val amount = 10.00
        val tipPercent = 20.00
        // tip amount is formatted this way in app implementation, value that we're checking must
        // match this formatting
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount, tipPercent, false)
        assertEquals(expectedTip, actualTip)
    }
}