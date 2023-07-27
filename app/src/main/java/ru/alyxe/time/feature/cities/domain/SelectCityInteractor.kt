package ru.alyxe.time.feature.cities.domain

import ru.alyxe.time.data.cities.CitiesStorage

internal class SelectCityInteractor(
    private val storage: CitiesStorage,
) : SelectCityUseCase {

    override fun selectCity(id: Int) = storage.changeCity(id)

}
