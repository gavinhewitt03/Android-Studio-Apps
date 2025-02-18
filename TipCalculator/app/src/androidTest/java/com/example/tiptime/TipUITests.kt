package com.example.tiptime

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.tiptime.ui.theme.TipTimeTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

// androidTest directory is for instrumentation tests

class TipUITests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        // instrumentation tests test app functionality through an instance of the app & its UI,
        // so UI content must be set
        composeTestRule.setContent {
            TipTimeTheme {
                TipTimeLayout()
            }
        }
        // accesses UI component with Text composable "Bill Amount" as a node
        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10") // populates "Bill Amount" text field with "10"

        composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")

        val expectedTip = NumberFormat.getCurrencyInstance().format(2) // same as in local test

        // ensures that the Text composable exists and contains the correct information.
        // if the composable does not exist, text inside assertExists is printed to terminal
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists(
            "No node with this text was found"
        )
    }
}