package ru.alyxe.time.core.navigation

import androidx.compose.runtime.Immutable

sealed interface RouteEvent {

    @Immutable
    object Initial : RouteEvent

    @Immutable
    data class Open(
        val route: String
    ) : RouteEvent

    @Immutable
    object Pop : RouteEvent

}
