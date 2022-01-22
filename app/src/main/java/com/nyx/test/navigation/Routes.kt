package com.nyx.test.navigation

sealed class Routes(val route: String) {
    object MainScreen : Routes("main")
    object SecondScreen : Routes("second")
}