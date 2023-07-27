package ru.alyxe.time.core.navigation

import kotlinx.coroutines.flow.StateFlow

internal interface StateFlowRouter : Router {

    val routeEvent: StateFlow<RouteEvent>

}
