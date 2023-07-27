package ru.alyxe.time.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.alyxe.time.core.ui.ScreenStarter
import ru.alyxe.time.feature.home.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            ScreenStarter(::HomeScreen)

        }
    }
}
