package ru.alyxe.time.core.navigation

import kotlinx.coroutines.flow.SharedFlow

internal interface SharedFlowRouter : Router {

    val sharedFlow: SharedFlow<String>

}
