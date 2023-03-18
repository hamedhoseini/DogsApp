package com.mihahoni.dogsapp.data.service

import com.mihahoni.dogsapp.data.model.BaseEntity
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("api/breeds/list/all")
    suspend fun getAllDogBreeds(): BaseEntity<Map<String, List<String>>>

    @GET("api/breed/{breed}/images/random")
    suspend fun getRandomImageByBreed(@Path("breed") breedName: String): BaseEntity<String>

    @GET("api/breed/{breed}/images")
    suspend fun getBreedAllImages(@Path("breed") breedName: String): BaseEntity<List<String>>
}