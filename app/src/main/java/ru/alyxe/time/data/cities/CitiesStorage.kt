package ru.alyxe.time.data.cities

import kotlinx.coroutines.flow.Flow
import ru.alyxe.time.entity.City

interface CitiesStorage {

    fun selectedCity(): Flow<City>

    fun changeCity(city: City)

    fun allCities(): Flow<List<City>>

}
