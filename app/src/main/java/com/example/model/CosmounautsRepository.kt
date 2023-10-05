package com.example.model

import android.util.Log
import com.example.model.api.CosmonautsWebService
import com.example.model.response.CosmonautsListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CosmounautsRepository(private val webService: CosmonautsWebService = CosmonautsWebService()) {
    fun getCosmonauts(successCallback: (response: CosmonautsListResponse?) -> Unit) {
        return webService.getCosmonauts().enqueue(object: Callback<CosmonautsListResponse>{
            override fun onResponse(
                call: Call<CosmonautsListResponse>,
                response: Response<CosmonautsListResponse>
            ) {
               if (response.isSuccessful) successCallback(response.body())
            }
            override fun onFailure(call: Call<CosmonautsListResponse>, t: Throwable) {
                Log.e("Error", t.toString())
            }
        })
    }
}