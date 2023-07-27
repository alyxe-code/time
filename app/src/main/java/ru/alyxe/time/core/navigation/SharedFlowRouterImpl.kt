package ru.alyxe.time.core.navigation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

internal class SharedFlowRouterImpl(
    context: CoroutineContext = EmptyCoroutineContext,
) : SharedFlowRouter {

    private val routerScope = CoroutineScope(
        context = Dispatchers.Main.immediate + context,
    )

    private val _sharedFlow = MutableSharedFlow<String>()
    override val sharedFlow = _sharedFlow.asSharedFlow()

    override fun navigate(route: String) {
        routerScope.launch {
            _sharedFlow.emit(route)
        }
    }

    override fun pop(): Boolean {
        val previousRoute = _sharedFlow.replayCache.lastOrNull()

        routerScope.launch {
            _sharedFlow.emit(previousRoute.orEmpty())
        }

        return previousRoute != null
    }

}
