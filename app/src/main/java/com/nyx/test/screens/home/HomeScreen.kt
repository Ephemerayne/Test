package com.nyx.test.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import com.nyx.test.navigation.Routes

@ExperimentalComposeUiApi
@Composable
fun MainScreen(navController: NavHostController) {
    Column {
        Text(text = "Hello")
        Button(onClick = { navController.navigate(Routes.SecondScreen.route) }) {
            Text(text = "Click")

        }
    }
}