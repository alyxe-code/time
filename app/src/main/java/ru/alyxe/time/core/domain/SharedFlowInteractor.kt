package ru.alyxe.time.core.domain

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.shareIn
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

abstract class SharedFlowInteractor<T>(
    context: CoroutineContext = EmptyCoroutineContext,
) : SharedFlowUseCase<T> {

    private val domainScope = CoroutineScope(
        context = Dispatchers.Default + context,
    )

    override val sharedFlow by lazy {
        flow().shareIn(
            scope = domainScope,
            started = SharingStarted.WhileSubscribed(),
            replay = 0,
        )
    }

    protected abstract fun flow(): Flow<T>
}
