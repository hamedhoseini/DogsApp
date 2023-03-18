package com.mihahoni.dogsapp.di

import com.mihahoni.dogsapp.data.repository.DogBreedRepository
import com.mihahoni.dogsapp.data.repository.DogBreedRepositoryImp
import com.mihahoni.dogsapp.data.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DogBreedRepositoryModule {

    @Singleton
    @Provides
    fun provideDogBreedRepository(
        apiService: ApiService
    ): DogBreedRepository {
        return DogBreedRepositoryImp(apiService)
    }
}