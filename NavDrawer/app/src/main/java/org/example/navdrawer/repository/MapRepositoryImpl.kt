package org.example.navdrawer.repository

import androidx.compose.runtime.mutableStateOf
import javax.inject.Inject

class MapRepositoryImpl @Inject constructor() : MapRepository {
    override var collecting = mutableStateOf(false)
}