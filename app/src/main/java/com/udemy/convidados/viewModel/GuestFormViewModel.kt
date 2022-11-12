package com.udemy.convidados.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.udemy.convidados.model.GuestModel
import com.udemy.convidados.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    // Acesso a dados
    private val repository = GuestRepository(application.applicationContext)

    private val _saveGuest = MutableLiveData<Boolean>()
    val saveGuest: LiveData<Boolean> = _saveGuest

    private var _guest = MutableLiveData<GuestModel>()
    val guest: LiveData<GuestModel> = _guest

    //Salva convidado
    fun save(guest: GuestModel) {
        if (guest.id == 0) {
            _saveGuest.value = repository.save(guest)
        } else {
            _saveGuest.value = repository.update(guest)
        }
    }

     //Carrega convidado
    fun getGuest(id: Int) {
         _guest.value = repository.getGuest(id)
    }
}