package org.example.navdrawer.repository

import androidx.compose.runtime.MutableState

interface MapRepository {
    val collecting: MutableState<Boolean>
}