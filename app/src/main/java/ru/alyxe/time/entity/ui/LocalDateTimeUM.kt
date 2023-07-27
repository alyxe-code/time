package ru.alyxe.time.entity.ui

import androidx.compose.runtime.Immutable
import java.time.LocalDateTime

@JvmInline
@Immutable
value class LocalDateTimeUM(
    val dateTime: LocalDateTime,
)

fun LocalDateTime.toUiModel() = LocalDateTimeUM(this)
