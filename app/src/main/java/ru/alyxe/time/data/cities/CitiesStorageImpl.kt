package ru.alyxe.time.data.cities

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.update
import ru.alyxe.time.entity.City

internal class CitiesStorageImpl : CitiesStorage {

    private val _selectedCity = MutableStateFlow(Cities[0])

    override fun selectedCity() = _selectedCity.asSharedFlow()

    override fun changeCity(city: City) = _selectedCity.update { city }

    override fun allCities() = flowOf(Cities)

    companion object {
        private val Cities = listOf(
            City(
                id = 0,
                title = "Москва",
                timeZone = "Europe/Moscow",
            ),
            City(
                id = 1,
                title = "Нью-Йорк",
                timeZone = "America/New_York",
            ),
            City(
                id = 2,
                title = "Гонконг",
                timeZone = "Asia/Hong_Kong",
            ),
            City(
                id = 3,
                title = "Минск",
                timeZone = "Europe/Minsk",
            ),
            City(
                id = 4,
                title = "Париж",
                timeZone = "Europe/Paris",
            ),
        )
    }
}
