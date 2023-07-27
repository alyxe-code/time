package ru.alyxe.time.feature.home.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.alyxe.time.core.ui.BaseScreen
import ru.alyxe.time.core.viewmodel.viewModel
import ru.alyxe.time.entity.ui.CityUM
import ru.alyxe.time.entity.ui.LocalDateTimeUM
import java.time.format.DateTimeFormatter

internal class HomeScreen : BaseScreen() {

    private val viewModel by viewModel { HomeViewModel(get()) }

    override fun modules() = listOf(HomeModule)

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    override fun Content() {
        val state by viewModel.state.collectAsState()

        Scaffold { innerPaddings ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPaddings),
            ) {
                Column {
                    Spacer(Modifier.weight(1f))
                    City(
                        state.city,
                        modifier = Modifier
                            .fillMaxWidth(),
                    )
                    Spacer(Modifier.height(8.dp))
                    DateTime(
                        state.dateTime,
                        modifier = Modifier
                            .fillMaxWidth(),
                    )
                    Spacer(Modifier.weight(1f))
                    Button(
                        onClick = viewModel::openCitesList,
                        modifier = Modifier
                            .fillMaxWidth(),
                    ) {
                        Text("Change city")
                    }
                }
            }
        }
    }

    @Composable
    private fun City(
        city: CityUM?,
        modifier: Modifier = Modifier,
    ) {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = city?.title.orEmpty(),
                // color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.displayMedium,
                textAlign = TextAlign.Center,
            )
        }
    }

    @Composable
    private fun DateTime(
        dateTime: LocalDateTimeUM?,
        modifier: Modifier = Modifier,
    ) {
        val formatter = remember { DateTimeFormatter.ofPattern("HH:mm") }

        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = remember(dateTime) {
                    dateTime
                        ?.dateTime
                        ?.let(formatter::format)
                        .orEmpty()
                },
                // color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.displayMedium,
                textAlign = TextAlign.Center,
            )
        }
    }
}
