package org.example.navdrawer.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.example.navdrawer.repository.MapRepository
import org.example.navdrawer.repository.MapRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMapRepository(): MapRepository {
        return MapRepositoryImpl()
    }
}