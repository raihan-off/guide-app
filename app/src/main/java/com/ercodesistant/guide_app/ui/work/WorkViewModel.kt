package com.ercodesistant.guide_app.ui.work

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WorkViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is work Fragment"
    }
    val text: LiveData<String> = _text
}