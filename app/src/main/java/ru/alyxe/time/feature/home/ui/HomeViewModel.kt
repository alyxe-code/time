package ru.alyxe.time.feature.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

internal class HomeViewModel(
    private val wiring: HomeWiring,
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    init {
        wiring.city
            .onEach { city ->
                _state.update {
                    it.copy(
                        city = city,
                    )
                }
            }
            .launchIn(viewModelScope)

        wiring.dateTime
            .onEach { dateTime ->
                _state.update {
                    it.copy(
                        dateTime = dateTime,
                    )
                }
            }
            .launchIn(viewModelScope)
    }

    fun openCitesList() = wiring.openCitiesList()
}
