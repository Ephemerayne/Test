package com.nyx.test.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.nyx.test.domain.main.MainViewModel
import com.nyx.test.domain.main.models.MainEvent
import com.nyx.test.lifecycle.ViewModel
import com.nyx.test.lifecycle.observeAsState
import com.nyx.test.navigation.Routes

@ExperimentalComposeUiApi
@Composable
fun MainScreen(
    navController: NavHostController
) {
    ViewModel(
        factory = { MainViewModel() },
        screenName = "HomeScreen"
    ) { viewModel ->
        val viewState = viewModel.viewStates().observeAsState()
        val viewActions = viewModel.viewActions().observeAsState()

        val inputState = remember { mutableStateOf(0) }

        viewState.value?.let { state ->
            Column {
                Text(text = state.walletSum.toString())
                Text(text = "Введите сумму")
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier.width(200.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        TextField(
                            value = inputState.value.toString(),
                            onValueChange = { input ->
                                inputState.value = input.toInt()
                            },
                            trailingIcon = {
                                if (inputState.value.toString().isNotEmpty()) {
                                    IconButton(
                                        onClick = {
                                            inputState.value = 0
                                        }
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Close,
                                            contentDescription = null
                                        )
                                    }
                                }
                            },
                            singleLine = true,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )
                    }
                    Button(
                        onClick = {
                            viewModel.obtainEvent(MainEvent.AddMoneyToWallet(inputState.value))
                        }) {
                        Text(text = "Добавить")
                    }
                }


                Button(onClick = { navController.navigate(Routes.SecondScreen.route) }) {
                    Text(text = "Click")

                }
            }
        }

        viewActions.value.let { action ->

        }
    }
}