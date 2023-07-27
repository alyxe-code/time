package ru.alyxe.time.core.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

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

fun <S : BaseScreen> NavGraphBuilder.screen(route: String, factory: () -> S) {
    composable(route) {
        ScreenStarter(factory)
    }
}
