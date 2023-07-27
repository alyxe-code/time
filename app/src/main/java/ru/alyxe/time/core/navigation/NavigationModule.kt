package ru.alyxe.time.core.navigation

import org.koin.dsl.bind
import org.koin.dsl.module

val NavigationModule = module {
    single { StateFlowRouterImpl() }
        .bind<StateFlowRouter>()
        .bind<Router>()
}
