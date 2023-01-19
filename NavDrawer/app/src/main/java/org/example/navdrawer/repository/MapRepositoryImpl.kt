package org.example.navdrawer.repository

import androidx.compose.runtime.mutableStateOf

class MapRepositoryImpl : MapRepository {
    override var collecting = mutableStateOf(false)
}