package com.mihahoni.dogsapp.data.repository

import com.mihahoni.dogsapp.data.model.BaseEntity
import com.mihahoni.dogsapp.data.service.ApiService
import javax.inject.Inject

class DogBreedRepositoryImp @Inject constructor(
    private val apiService: ApiService,
) : DogBreedRepository {
    override suspend fun getAllDogBreeds(): BaseEntity<Map<String, List<String>>> {
        return apiService.getAllDogBreeds()
    }

    override suspend fun getRandomImageByBreed(breedName: String): BaseEntity<String> {
        return apiService.getRandomImageByBreed(breedName)
    }


}