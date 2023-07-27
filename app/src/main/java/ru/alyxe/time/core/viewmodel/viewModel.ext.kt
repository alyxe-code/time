package ru.alyxe.time.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import org.koin.core.Koin

inline fun <reified VM : ViewModel> KoinViewModelStoreOwner.viewModel(
    noinline storeOwner: () -> ViewModelStoreOwner = { this },
    ignoreCache: Boolean = false,
    noinline factory: Koin.() -> VM,
): Lazy<VM> {
    return lazy {
        if (ignoreCache) {
            scope
                .getKoin()
                .run(factory)
        } else {
            ViewModelProvider(
                storeOwner(),
                object : ViewModelProvider.Factory {
                    @Suppress("UNCHECKED_CAST")
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        return scope
                            .getKoin()
                            .run(factory) as T
                    }
                }
            )[VM::class.java]
        }
    }
}
