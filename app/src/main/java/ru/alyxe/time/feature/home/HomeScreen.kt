package ru.alyxe.time.feature.home

import androidx.compose.runtime.Composable
import org.koin.core.component.inject
import org.koin.dsl.module
import ru.alyxe.time.core.ui.BaseScreen

internal class HomeScreen : BaseScreen() {

    private val viewModel by inject<HomeViewModel>()

    override fun modules() = listOf(
        module {
            // DI
        }
    )

    @Composable
    override fun Content() {
        TODO("Not yet implemented")
    }
}
