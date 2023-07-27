package ru.alyxe.time.feature.cities.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.alyxe.time.core.ui.BaseScreen
import ru.alyxe.time.core.viewmodel.viewModel
import ru.alyxe.time.entity.ui.CityUM

class CitiesScreen : BaseScreen() {

    private val viewModel by viewModel { CitiesViewModel(get()) }

    override fun modules() = listOf(CitiesModule)

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    override fun Content() {
        val state by viewModel.state.collectAsState()

        Scaffold { innerPaddings ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPaddings)
                    .padding(16.dp)
            ) {
                if (state.cities.isEmpty()) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center,
                    ) {
                        Text(
                            text = "No cities presented",
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.bodyLarge,
                        )
                    }
                } else {
                    LazyColumn {
                        items(state.cities) { city ->
                            CityButton(
                                city = city,
                                onClick = viewModel::changeCity,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
            }
        }
    }

    @Composable
    private fun CityButton(
        city: CityUM,
        onClick: (CityUM) -> Unit,
        modifier: Modifier = Modifier,
    ) {
        Button(
            modifier = modifier,
            onClick = { onClick(city) },
        ) {
            Text(
                text = city.title,
            )
        }
    }
}
