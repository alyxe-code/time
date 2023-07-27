package ru.alyxe.time.core.ui

import androidx.lifecycle.ViewModelStore
import org.koin.core.component.newScope
import org.koin.core.module.Module
import ru.alyxe.time.core.viewmodel.KoinViewModelStoreOwner

abstract class BaseScreen : Screen, KoinViewModelStoreOwner {

    override val scope by newScope()

    private var _viewModelStore: ViewModelStore? = null
    override val viewModelStore
        get() = _viewModelStore ?: error("Screen is not attached")

    abstract fun modules(): List<Module>

    override fun onAttach() {
        scope
            .getKoin()
            .loadModules(
                modules = modules(),
                allowOverride = true,
            )

        _viewModelStore = ViewModelStore()
    }

    override fun onDetach() {
        _viewModelStore?.clear()
        _viewModelStore = null

        scope.close()
    }

}
