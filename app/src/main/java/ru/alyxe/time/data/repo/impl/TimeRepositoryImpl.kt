package ru.alyxe.time.data.repo.impl

import ru.alyxe.time.data.network.api.TimeApi
import ru.alyxe.time.data.repo.api.TimeRepository
import java.time.LocalDateTime

internal class TimeRepositoryImpl(
    private val api: TimeApi,
) : TimeRepository {

    override suspend fun fetchTime(
        timeZone: String
    ): LocalDateTime = api
        .fetchTime(timeZone)
        .dateTime
        .require("dateTime")
        .let(LocalDateTime::parse)

}
