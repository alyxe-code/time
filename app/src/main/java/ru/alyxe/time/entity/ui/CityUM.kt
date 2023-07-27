package ru.alyxe.time.entity.ui

import androidx.compose.runtime.Immutable
import ru.alyxe.time.entity.City

@Immutable
data class CityUM(
    val id: Int,
    val title: String,
)

fun City.toUiModel() = CityUM(id, title)
