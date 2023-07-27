package ru.alyxe.time.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import ru.alyxe.time.feature.home.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val home = remember {
                HomeScreen()
                    .also { it.onAttach() }
            }

            DisposableEffect(Unit) {
                onDispose { home.onDetach() }
            }

        }
    }
}
