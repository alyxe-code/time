package ru.alyxe.time.core.ui

import androidx.compose.runtime.Composable

interface Screen {

    fun onAttach()
    fun onDetach()

    @Composable
    fun Content()

}
