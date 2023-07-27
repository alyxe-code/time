package ru.alyxe.time.feature.cities.domain

import ru.alyxe.time.core.domain.SharedFlowInteractor
import ru.alyxe.time.data.cities.CitiesStorage
import ru.alyxe.time.entity.City

internal class FetchAllCitiesInteractor(
    private val storage: CitiesStorage,
) : SharedFlowInteractor<List<City>>(), FetchAllCitiesUseCase {
    override fun flow() = storage.allCities()
}
