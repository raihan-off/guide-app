package com.ercodesistant.guide_app.ui.information.subCategory

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ercodesistant.guide_app.model.WebLink
import com.ercodesistant.guide_app.network.WebLinkApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CodingCateViewModel: ViewModel() {

    private val data = MutableLiveData<List<WebLink>>()
    private val status = MutableLiveData<WebLinkApi.ApiStatus>()

    init {
        retriveData()
    }

    private fun retriveData(){
        viewModelScope.launch(Dispatchers.IO){
            status.postValue(WebLinkApi.ApiStatus.LOADING)
            try {
                data.postValue(WebLinkApi.service.getWebLink())
                status.postValue(WebLinkApi.ApiStatus.SUCCESS)
            } catch (e: Exception){
                Log.d("CodingCateViewModel", "Failure: ${e.message}")
                status.postValue(WebLinkApi.ApiStatus.FAILED)
            }
        }
    }

    fun getData(): LiveData<List<WebLink>> = data

    fun getStatus(): LiveData<WebLinkApi.ApiStatus> = status
}