package ru.alyxe.time.feature.cities.domain

interface SelectCityUseCase {
    fun selectCity(id: Int): Boolean
}
