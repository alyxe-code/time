package ru.alyxe.time.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.koin.android.ext.android.getKoin
import ru.alyxe.time.core.ui.screen
import ru.alyxe.time.data.DataModule
import ru.alyxe.time.data.network.NetworkModule
import ru.alyxe.time.feature.home.ui.HomeScreen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getKoin().loadModules(
            listOf(
                DataModule,
                NetworkModule,
            )
        )

        setContent {

            MaterialTheme {
                NavHost(
                    navController = rememberNavController(),
                    startDestination = "home",
                ) {
                    screen(
                        route = "home",
                        factory = ::HomeScreen
                    )
                }
            }

        }
    }
}
