package org.example.navdrawer.navigation

sealed class Screen(val route: String, val title: String) {
    object Home : Screen("home", "Home")
    object Map: Screen("map", "Map")
}

val screens = listOf(
    Screen.Home,
    Screen.Map
)