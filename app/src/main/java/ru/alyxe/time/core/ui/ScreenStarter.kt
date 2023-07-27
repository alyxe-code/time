package ru.alyxe.time.core.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember

@Composable
fun <S : BaseScreen> ScreenStarter(
    factory: () -> S,
) {
    val screen = remember {
        factory().also { it.onAttach() }
    }

    DisposableEffect(Unit) {
        onDispose {
            screen.onDetach()
        }
    }

    screen.Content()
}
