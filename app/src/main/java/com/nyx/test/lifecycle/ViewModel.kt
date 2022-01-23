package com.nyx.test.lifecycle

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import com.nyx.test.domain.base.models.KViewModel

@Composable
fun <T : KViewModel> ViewModel(
    factory: () -> T,
    screenName: String,
    content: @Composable (T) -> Unit
) {

    // Instantiate KViewModel to use
    val viewModel = remember { factory.invoke() }

    // Show content
    content(viewModel)

    DisposableEffect(Unit) {
        onDispose {
            viewModel.clear()
        }
    }
}