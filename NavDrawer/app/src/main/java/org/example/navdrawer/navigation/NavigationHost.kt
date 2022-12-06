package org.example.navdrawer.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import org.example.navdrawer.screens.HomeScreen
import org.example.navdrawer.screens.MapScreen

@Composable
fun NavigationHost(navController: NavController) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) { HomeScreen() }
        composable(Screen.Map.route) { MapScreen() }
    }
}
