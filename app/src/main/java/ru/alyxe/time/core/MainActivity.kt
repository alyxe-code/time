package ru.alyxe.time.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject
import ru.alyxe.time.core.navigation.NavigationModule
import ru.alyxe.time.core.navigation.SharedFlowRouter
import ru.alyxe.time.core.ui.screen
import ru.alyxe.time.data.DataModule
import ru.alyxe.time.data.network.NetworkModule
import ru.alyxe.time.feature.home.ui.HomeScreen

class MainActivity : ComponentActivity() {

    private val router by inject<SharedFlowRouter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getKoin().loadModules(
            listOf(
                DataModule,
                NetworkModule,
                NavigationModule,
            )
        )

        setContent {
            val navController = rememberNavController()

            MaterialTheme {

                NavHost(
                    navController = navController,
                    startDestination = "home",
                ) {
                    screen(
                        route = "home",
                        factory = ::HomeScreen
                    )

                    composable("cities") {
                        Text(text = "Cities")
                    }
                }
            }

            RouterEffect(navController)

        }
    }

    @Composable
    private fun RouterEffect(
        navController: NavController,
    ) {
        val route by router.sharedFlow.collectAsState(initial = "")

        LaunchedEffect(route) {
            if (route.isNotBlank()) {
                navController.navigate(route)
            }
        }
    }

    override fun onBackPressed() {
        if (!router.pop()) {
            super.onBackPressed()
        }
    }
}
