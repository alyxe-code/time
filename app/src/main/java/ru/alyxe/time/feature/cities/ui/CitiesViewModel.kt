package ru.alyxe.time.feature.cities.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import ru.alyxe.time.entity.ui.CityUM

internal class CitiesViewModel(
    private val wiring: CitiesWiring,
) : ViewModel() {

    private val _state = MutableStateFlow(CitiesState())
    val state = _state.asStateFlow()

    init {
        wiring.allCities
            .onEach { cities ->
                _state.update { it.copy(cities = cities) }
            }
            .launchIn(viewModelScope)
    }

    fun changeCity(city: CityUM) {
        if (wiring.changeCity(city.id)) {
            wiring.close()
        }
    }

}
