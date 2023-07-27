package ru.alyxe.time.data.network.api

import retrofit2.http.GET
import retrofit2.http.Query

interface TimeApi {

    @GET("Time/current/zone")
    suspend fun fetchTime(
        @Query("timeZone") timeZone: String
    ): TimeZoneResponse

}
