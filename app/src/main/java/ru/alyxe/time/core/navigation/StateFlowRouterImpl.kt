package ru.alyxe.time.core.navigation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

internal class StateFlowRouterImpl(
    context: CoroutineContext = EmptyCoroutineContext,
) : StateFlowRouter {

    private val routerScope = CoroutineScope(
        context = Dispatchers.Main.immediate + context,
    )

    private val routeEventFlow = MutableStateFlow<RouteEvent>(RouteEvent.Initial)
    override val routeEvent = routeEventFlow.asStateFlow()

    override fun navigate(route: String) {
        routerScope.launch {
            routeEventFlow.value = RouteEvent.Open(route)
        }
    }

    override fun pop() {
        routerScope.launch {
            routeEventFlow.value = RouteEvent.Pop
        }
    }

}
