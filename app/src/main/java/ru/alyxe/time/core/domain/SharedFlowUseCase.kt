package ru.alyxe.time.core.domain

import kotlinx.coroutines.flow.SharedFlow

interface SharedFlowUseCase<T> {

    val sharedFlow: SharedFlow<T>

}
