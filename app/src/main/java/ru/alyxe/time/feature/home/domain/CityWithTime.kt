package ru.alyxe.time.feature.home.domain

import ru.alyxe.time.entity.City
import java.time.LocalDateTime

class CityWithTime(
    val city: City,
    val dateTime: LocalDateTime,
)
