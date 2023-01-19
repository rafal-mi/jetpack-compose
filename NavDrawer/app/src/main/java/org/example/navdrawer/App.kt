package org.example.navdrawer

import android.app.Application
import org.example.navdrawer.repository.MapRepository

class App : Application() {

    val mapRepository: MapRepository by lazy {
        MapRepository()
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