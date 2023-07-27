package ru.alyxe.time.feature.home.domain

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.distinctUntilChangedBy
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.retry
import ru.alyxe.time.core.domain.SharedFlowInteractor
import ru.alyxe.time.data.cities.CitiesStorage
import ru.alyxe.time.data.repo.api.TimeRepository
import java.time.LocalDateTime
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds

class ListenSelectedCityAndTimeInteractor(
    private val storage: CitiesStorage,
    private val repository: TimeRepository,
) : SharedFlowInteractor<CityWithTime>(), ListenSelectedCityAndTimeUseCase {

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun flow() = storage
        .selectedCity()
        .flatMapLatest { city ->
            dateTimeFlow(city.timeZone).map { dateTime ->
                CityWithTime(
                    city = city,
                    dateTime = dateTime
                )
            }
        }

    private fun dateTimeFlow(
        timeZone: String
    ) = tickerFlow(100.milliseconds)
        .distinctUntilChangedBy { LocalDateTime.now().minute }
        .map { repository.fetchTime(timeZone) }
        .retry()

    private fun tickerFlow(
        period: Duration,
    ) = flow {
        while (true) {
            emit(Unit)
            delay(period)
        }
    }
}
