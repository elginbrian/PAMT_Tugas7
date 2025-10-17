package com.filkom.mycv2

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class User(val nim: String = "", val nama: String = "", val email: String = "", val alamat: String = "")

class MainViewModel : ViewModel() {
    private val _lastLoginEmail = MutableStateFlow("")
    val lastLoginEmail: StateFlow<String> = _lastLoginEmail

    private val _lastRegistered = MutableStateFlow(User())
    val lastRegistered: StateFlow<User> = _lastRegistered

    fun login(nim: String, nama: String, email: String) {
        _lastLoginEmail.value = email
    }

    fun register(nim: String, nama: String, email: String, alamat: String) {
        _lastRegistered.value = User(nim, nama, email, alamat)
    }
}

