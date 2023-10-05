package com.example.composablecallback06_10_2023.ui.cosmonauts

import androidx.lifecycle.ViewModel
import com.example.model.CosmounautsRepository
import com.example.model.response.CosmonautsListResponse

class CosmonautsListViewModel(private val repository: CosmounautsRepository = CosmounautsRepository()): ViewModel() {
    fun getCosmonauts(successCallback: (response: CosmonautsListResponse?) -> Unit) {
        return repository.getCosmonauts() {
            response ->
            successCallback(response)
        }
    }
}