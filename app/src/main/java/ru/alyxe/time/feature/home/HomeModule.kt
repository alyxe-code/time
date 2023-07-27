package ru.alyxe.time.feature.home

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.alyxe.time.feature.home.domain.ListenSelectedCityAndTimeInteractor
import ru.alyxe.time.feature.home.domain.ListenSelectedCityAndTimeUseCase

val HomeModule = module {
    singleOf(::ListenSelectedCityAndTimeInteractor)
        .bind<ListenSelectedCityAndTimeUseCase>()

    singleOf(::HomeWiringImpl)
        .bind<HomeWiring>()
}
