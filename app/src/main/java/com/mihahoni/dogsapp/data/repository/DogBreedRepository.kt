package com.mihahoni.dogsapp.data.repository

import com.mihahoni.dogsapp.data.model.BaseEntity

interface DogBreedRepository {
    suspend fun getAllDogBreeds(): BaseEntity<Map<String, List<String>>>
    suspend fun getRandomImageByBreed(breedName: String): BaseEntity<String>
}