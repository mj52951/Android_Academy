package com.example.android_academy

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {
    var contacts = MutableLiveData<MutableList<String>>()
}