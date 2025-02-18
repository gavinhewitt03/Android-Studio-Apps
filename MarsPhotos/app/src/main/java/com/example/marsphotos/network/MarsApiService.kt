package com.example.marsphotos.network

import com.example.marsphotos.model.MarsPhoto
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build() // creates retrofit object

interface MarsApiService {
    @GET("photos") // specifies the HTTP request is a GET request with endpoint photos
    suspend fun getPhotos() : List<MarsPhoto> // when getPhotos is called, retrofit will append photos to base URL
    // suspend fun to make async and not block calling thread from continuing
}

object MarsApi {
    val retrofitService : MarsApiService by lazy { // lazy delays initialization til needed
        retrofit.create(MarsApiService::class.java) // implements interface
    }
    // MarsApi.retrofitService will now access the same object implementing the interface
}
