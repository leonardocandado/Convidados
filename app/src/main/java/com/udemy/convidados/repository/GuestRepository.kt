package com.udemy.convidados.repository

import android.content.Context
import com.udemy.convidados.model.GuestModel

class GuestRepository (context: Context) {

    //Acesso ao banco de dados
    private val guestDataBase = GuestDatabase.getDataBase(context).guestDAO()

    companion object {
        private lateinit var repository: GuestRepository

        fun getInstance(context: Context): GuestRepository {
            if (!::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }
    }

    fun save(guest: GuestModel): Boolean = guestDataBase.insert(guest) > 0

    fun update(guest: GuestModel): Boolean = guestDataBase.update(guest) > 0

    fun delete(id: Int) = guestDataBase.delete(getGuest(id))


    fun getAllGuests(): List<GuestModel> = guestDataBase.getAllGuests()

    fun getGuest(id: Int): GuestModel = guestDataBase.get(id)


    fun getAllPresent(): List<GuestModel> = guestDataBase.getPresent()

    fun getAllAbsent(): List<GuestModel> = guestDataBase.getAbsent()

}