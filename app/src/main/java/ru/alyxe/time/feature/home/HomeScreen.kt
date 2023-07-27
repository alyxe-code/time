package ru.alyxe.time.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.dsl.module
import ru.alyxe.time.core.ui.BaseScreen
import ru.alyxe.time.core.viewmodel.viewModel

internal class HomeScreen : BaseScreen() {

    private val viewModel by viewModel { HomeViewModel() }

    override fun modules() = listOf(
        module {
            // DI
        }
    )

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    override fun Content() {
        Scaffold { innerPaddings ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPaddings),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Home",
                )
            }
        }
    }
}
