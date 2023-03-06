package com.example.android_academy

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {
    var contacts = MutableLiveData<MutableList<String>>()

    fun addContact(contact: String) {
        if (contacts.value == null) {
            contacts.value = mutableListOf()
        }
        contacts.value!!.add(contact)
    }
}