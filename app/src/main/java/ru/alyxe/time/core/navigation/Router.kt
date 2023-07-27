package ru.alyxe.time.core.navigation

interface Router {

    fun navigate(route: String)
    fun pop()

}
