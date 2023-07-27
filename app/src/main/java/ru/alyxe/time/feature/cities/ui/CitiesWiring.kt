package ru.alyxe.time.feature.cities.ui

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.alyxe.time.core.navigation.Router
import ru.alyxe.time.entity.ui.CityUM
import ru.alyxe.time.entity.ui.toUiModel
import ru.alyxe.time.feature.cities.domain.FetchAllCitiesUseCase
import ru.alyxe.time.feature.cities.domain.SelectCityUseCase

internal interface CitiesWiring {

    val allCities: Flow<List<CityUM>>

    fun changeCity(id: Int): Boolean

    fun close()

}

internal class CitiesWiringImpl(
    private val router: Router,
    private val fetchAllCitiesUseCase: FetchAllCitiesUseCase,
    private val selectCityUseCase: SelectCityUseCase,
) : CitiesWiring {
    override val allCities: Flow<List<CityUM>>
        get() = fetchAllCitiesUseCase.sharedFlow.map { cities ->
            cities.map { it.toUiModel() }
        }

    override fun changeCity(id: Int) = selectCityUseCase.selectCity(id)

    override fun close() {
        router.pop()
    }

}
