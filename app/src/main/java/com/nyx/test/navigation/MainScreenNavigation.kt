package com.nyx.test.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nyx.test.screens.TestScreenTwo
import com.nyx.test.screens.home.MainScreen

@ExperimentalComposeUiApi
@Composable
fun MainScreenNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.MainScreen.route) {
        composable(Routes.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(Routes.SecondScreen.route) {
            TestScreenTwo()
        }

        // Settings Route, Notice the "/{id}" in last,
        // its the argument passed down from homeScreen
//        composable(Routes.Settings.route + "/{id}") { navBackStack ->
//
//            // Extracting the argument
//            val counter = navBackStack.arguments?.getString("id")
//
//            // Setting screen,
//            // Pass the extracted Counter
//            Setting(counter = counter)
//        }
    }
}