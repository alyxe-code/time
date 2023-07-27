package ru.alyxe.time.feature.cities.domain

import ru.alyxe.time.core.domain.SharedFlowUseCase
import ru.alyxe.time.entity.City

interface FetchAllCitiesUseCase : SharedFlowUseCase<List<City>>
