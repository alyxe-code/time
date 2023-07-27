package ru.alyxe.time.data.repo.api

import java.time.LocalDateTime

interface TimeRepository {

    suspend fun fetchTime(timeZone: String): LocalDateTime

}
