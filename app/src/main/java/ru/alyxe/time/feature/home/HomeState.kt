package ru.alyxe.time.feature.home

import androidx.compose.runtime.Immutable
import ru.alyxe.time.entity.ui.CityUM
import ru.alyxe.time.entity.ui.LocalDateTimeUM

@Immutable
data class HomeState(
    val city: CityUM? = null,
    val dateTime: LocalDateTimeUM? = null,
)
