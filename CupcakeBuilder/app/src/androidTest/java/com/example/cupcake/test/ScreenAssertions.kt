package com.example.cupcake.test

import androidx.navigation.NavController
import org.junit.Assert

// extension function for the NavController class
fun NavController.assertCurrentRouteName(expectedRouteName: String) {
    Assert.assertEquals(expectedRouteName, currentBackStackEntry?.destination?.route)
}