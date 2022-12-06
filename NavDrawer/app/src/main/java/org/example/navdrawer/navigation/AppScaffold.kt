package org.example.navdrawer.navigation

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import org.example.navdrawer.App.Companion.TAG

@Composable
fun AppScaffold() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    var currentScreen by remember {
        mutableStateOf<Screen>(Screen.Home)
    }

    var topBar : @Composable () -> Unit = {

        Log.i(TAG, "Top bar composes with current screen $currentScreen")

        TopBar(
            title = currentScreen!!.title,
            buttonIcon = Icons.Filled.Menu,
            onButtonClicked = {
                scope.launch {
                    scaffoldState.drawerState.open()
                }
            }
        )
    }

    Scaffold(
        topBar = {
            topBar()
        },
        scaffoldState = scaffoldState,
        drawerContent = {
            Drawer { route ->
                scope.launch {
                    scaffoldState.drawerState.close()
                }
                navController.navigate(route) {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
                val screen = screens.find { it.route == route }
                screen?.let {
                    currentScreen = it
                }
            }
        }
    ) { innerPadding ->
        NavigationHost(navController = navController)
    }

}