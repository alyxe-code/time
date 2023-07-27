package ru.alyxe.time.data

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import ru.alyxe.time.data.cities.CitiesStorage
import ru.alyxe.time.data.cities.CitiesStorageImpl
import ru.alyxe.time.data.network.api.TimeApi
import ru.alyxe.time.data.repo.api.TimeRepository
import ru.alyxe.time.data.repo.impl.TimeRepositoryImpl

val DataModule = module {
    singleOf(::CitiesStorageImpl)
        .bind<CitiesStorage>()

    factory<TimeRepository> {
        TimeRepositoryImpl(
            api = get<Retrofit>()
                .create(TimeApi::class.java)
        )
    }
}
