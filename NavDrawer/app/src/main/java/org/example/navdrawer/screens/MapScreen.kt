package org.example.navdrawer.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import org.example.navdrawer.App.Companion.TAG

@Composable
fun MapScreen() {
    val viewModel: MapViewModel = hiltViewModel()

    Log.d(TAG, "Composing MapScreen, collecting == ${viewModel.collecting}")

    MapScreenContent(viewModel = viewModel)
}

@Composable
fun MapScreenContent(viewModel: MapViewModel) {
    Column() {
        Text("Map Screen")
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Collecting"
            )
            Switch(
                checked = viewModel.collecting,
                onCheckedChange = {
                    // viewModel.collecting = it
                    viewModel.setCollectingState(it)
                }
            )

        }
    }
}