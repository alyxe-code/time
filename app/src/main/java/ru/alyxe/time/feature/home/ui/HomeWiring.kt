package ru.alyxe.time.feature.home.ui

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.alyxe.time.entity.ui.CityUM
import ru.alyxe.time.entity.ui.LocalDateTimeUM
import ru.alyxe.time.entity.ui.toUiModel
import ru.alyxe.time.feature.home.domain.ListenSelectedCityAndTimeUseCase

internal interface HomeWiring {

    val city: Flow<CityUM>
    val dateTime: Flow<LocalDateTimeUM>

    fun openCitiesList()

}

internal class HomeWiringImpl(
    private val useCase: ListenSelectedCityAndTimeUseCase,
) : HomeWiring {

    override val city: Flow<CityUM>
        get() = useCase.sharedFlow.map { it.city.toUiModel() }

    override val dateTime: Flow<LocalDateTimeUM>
        get() = useCase.sharedFlow.map { it.dateTime.toUiModel() }

    override fun openCitiesList() {
        TODO("Not yet implemented")
    }

}
