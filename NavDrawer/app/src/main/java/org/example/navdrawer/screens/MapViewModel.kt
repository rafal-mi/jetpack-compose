package org.example.navdrawer.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.Snapshot
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.SavedStateHandleSaveableApi
import androidx.lifecycle.viewmodel.compose.saveable
import dagger.hilt.android.lifecycle.HiltViewModel
import org.example.navdrawer.App
import org.example.navdrawer.App.Companion.TAG
import org.example.navdrawer.repository.MapRepository
import javax.inject.Inject

@OptIn(SavedStateHandleSaveableApi::class)
@HiltViewModel
class MapViewModel @Inject constructor(
    private val mapRepository: MapRepository,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    private var _collecting: Boolean by savedStateHandle.saveable {
        mutableStateOf(false)
    }
    var collecting: Boolean
        get() = _collecting
        set(v) {
            _collecting = v
            mapRepository.collecting.value = v
        }

    init {
        Log.i(TAG, "In MapViewModel.init, this is $this")
        Log.i(TAG, "In MapViewModel.init, savedStateHandle is $savedStateHandle")
        Log.i(TAG, "In MapViewModel.init, mapRepository is $mapRepository")

        collecting = mapRepository.collecting.value
    }

    override fun onCleared() {
        Log.d(TAG, "In MapViewModel.onCleared")

        super.onCleared()
    }
}