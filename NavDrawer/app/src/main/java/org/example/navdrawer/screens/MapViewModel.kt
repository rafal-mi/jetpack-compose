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
import org.example.navdrawer.App
import org.example.navdrawer.App.Companion.TAG

@OptIn(SavedStateHandleSaveableApi::class)
class MapViewModel(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    var collecting: Boolean by savedStateHandle.saveable {
        mutableStateOf(false)
    }

    fun setCollectingState(v: Boolean) {
        collecting = v
        App.instance.mapRepository.collecting.value = v
    }

    init {
        Log.i(TAG, "In MapViewModel.init, this is $this, savedStateHandle is $savedStateHandle")

        val repository = App.instance.mapRepository
        collecting = repository.collecting.value
    }

    override fun onCleared() {
        Log.d(TAG, "In MapViewModel.onCleared")

        super.onCleared()
    }
}