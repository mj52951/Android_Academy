package com.example.android_academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel() {
    private var _contacts: MutableLiveData<ArrayList<Contact>> = MutableLiveData(arrayListOf())
    val contacts: LiveData<ArrayList<Contact>>
        get() = _contacts

    fun addContact(contact: Contact) {
        val tempData = _contacts.value
        tempData?.add(contact)
        _contacts.value = tempData!!
    }
}