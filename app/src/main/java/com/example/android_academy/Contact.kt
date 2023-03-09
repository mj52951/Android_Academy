package com.example.android_academy

data class Contact(val firstName: String, val lastName: String, val age: Int, val oib: Int) {

    override fun toString(): String {
        return "$firstName $lastName $age $oib"
    }
}