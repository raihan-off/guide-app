package com.ercodesistant.guide_app.network

import com.ercodesistant.guide_app.model.WebLink
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/" + "raihan-off/backend-guide-in/static-api/"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface WebLinkApiService {
    @GET("weblink.json")
    suspend fun getWebLink() : List<WebLink>
}

object WebLinkApi {
    val service: WebLinkApiService by lazy {
        retrofit.create(WebLinkApiService::class.java)
    }

    //fun getWebLinkUrl(imageId: String): String {return "$BASE_URL$imageId.jpg"}

    enum class ApiStatus { LOADING, SUCCESS, FAILED }
}