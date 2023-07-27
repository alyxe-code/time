package ru.alyxe.time.feature.cities.ui

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.alyxe.time.feature.cities.domain.FetchAllCitiesInteractor
import ru.alyxe.time.feature.cities.domain.FetchAllCitiesUseCase
import ru.alyxe.time.feature.cities.domain.SelectCityInteractor
import ru.alyxe.time.feature.cities.domain.SelectCityUseCase

val CitiesModule = module {

    singleOf(::FetchAllCitiesInteractor)
        .bind<FetchAllCitiesUseCase>()

    singleOf(::SelectCityInteractor)
        .bind<SelectCityUseCase>()

    singleOf(::CitiesWiringImpl)
        .bind<CitiesWiring>()

}
