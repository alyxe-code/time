package ru.alyxe.time.feature.cities.ui

import androidx.compose.runtime.Immutable
import ru.alyxe.time.entity.ui.CityUM

@Immutable
internal data class CitiesState(
    val cities: List<CityUM> = emptyList(),
)
