package ru.alyxe.time.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import ru.alyxe.time.core.ui.screen
import ru.alyxe.time.feature.home.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
