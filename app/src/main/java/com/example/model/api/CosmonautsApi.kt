package com.example.model.api

import com.example.model.response.CosmonautsListResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class CosmonautsWebService {
    private lateinit var api: CosmonautsApi
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.open-notify.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(CosmonautsApi::class.java)
    }
    fun getCosmonauts(): Call<CosmonautsListResponse> {
        return api.getCosmonauts()
    }


    interface CosmonautsApi {
        @GET("astros.json")
        fun getCosmonauts(): Call<CosmonautsListResponse>
    }
}