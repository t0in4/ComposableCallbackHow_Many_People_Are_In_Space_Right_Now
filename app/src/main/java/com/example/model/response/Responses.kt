package com.example.model.response

import com.google.gson.annotations.SerializedName

data class CosmonautsListResponse(
    val people: List<CosmonautsResponse>,
    @SerializedName("number") var number  : Int?,
    @SerializedName("message") var message : String?)

data class CosmonautsResponse(
    @SerializedName("name") val name: String,
    @SerializedName("craft") val craft: String
)