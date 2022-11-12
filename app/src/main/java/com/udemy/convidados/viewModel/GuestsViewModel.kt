package com.udemy.convidados.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.udemy.convidados.model.GuestModel
import com.udemy.convidados.repository.GuestRepository

class GuestsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = GuestRepository(application.applicationContext)

    private val _guestList = MutableLiveData<List<GuestModel>>()
    val guestList: LiveData<List<GuestModel>> = _guestList

    fun getAll() {
        _guestList.value = repository.getAllGuests()
    }

    fun getAbsent() {
        _guestList.value = repository.getAllAbsent()
    }

    fun getPresent() {
        _guestList.value = repository.getAllPresent()
    }

    fun delete(id: Int) {
        repository.delete(id)
    }

}