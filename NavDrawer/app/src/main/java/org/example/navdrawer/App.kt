package org.example.navdrawer

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import org.example.navdrawer.repository.MapRepositoryImpl

@HiltAndroidApp
class App : Application() {

    val mapRepository: MapRepositoryImpl by lazy {
        MapRepositoryImpl()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        const val TAG = "NavDrawer"
        lateinit var instance: App
    }
}