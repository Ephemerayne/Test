package com.nyx.test.lifecycle

import androidx.compose.runtime.*

@Composable
fun <T> CFlow<T>.observeAsState(initial: T? = null): State<T?> {
    val state = remember { mutableStateOf(initial) }
    val flow = this
    DisposableEffect(this) {
        val observer = flow.watch { state.value = it }
        onDispose {
            observer.close()
        }
    }

    return state
}