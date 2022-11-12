package com.udemy.convidados.repository

import android.content.Context

class GuestRepositoryOld private constructor(context: Context) {

    /*
    //Acesso ao banco de dados
    private val guestDataBase = GuestDataBase(context)

    companion object {
        private lateinit var repository: GuestRepository

        fun getInstance(context: Context): GuestRepository {
            if (!::repository.isInitialized) {
                repository = GuestRepository(context)
            }
            return repository
        }
    }

    fun save(guest: GuestModel): Boolean {
        return try {
            // writableDatabase - Para fazer escrita de dados
            val dataBase = guestDataBase.writableDatabase

            val values = ContentValues()
            values.put(Constants.GUEST.COLUMNS.NAME, guest.name)
            values.put(Constants.GUEST.COLUMNS.PRESENCE, guest.presence)

            dataBase.insert(Constants.GUEST.TABLE_NAME, null, values)
            true
        } catch (e: Exception) {
            false
        }

    }

    fun update(guest: GuestModel): Boolean {
        return try {

            val presence = if (guest.presence) 1 else 0
            val values = ContentValues()

            values.put(Constants.GUEST.COLUMNS.NAME, guest.name)
            values.put(Constants.GUEST.COLUMNS.PRESENCE, presence)

            val selection = Constants.GUEST.COLUMNS.ID + " = ?"
            val args = arrayOf(guest.id.toString())

            guestDataBase.writableDatabase.update(
                Constants.GUEST.TABLE_NAME,
                values,
                selection,
                args
            )

            true
        } catch (e: Exception) {
            false
        }
    }

    fun delete(id: Int): Boolean {
        return try {
            val dataBase = guestDataBase.writableDatabase
            val selection = Constants.GUEST.COLUMNS.ID + " = ?"
            val args = arrayOf(id.toString())

            dataBase.delete(
                Constants.GUEST.TABLE_NAME,
                selection,
                args
            )
            true

        } catch (e: Exception) {
            false
        }
    }

    fun getAllGuests(): List<GuestModel> {
        val listGuest : MutableList<GuestModel> = ArrayList()

        return try {
            val dataBase = guestDataBase.readableDatabase

            // Colunas que serão retornadas
            val projection = arrayOf(
                Constants.GUEST.COLUMNS.ID,
                Constants.GUEST.COLUMNS.NAME,
                Constants.GUEST.COLUMNS.PRESENCE
            )
            val cursor = dataBase.query(
                Constants.GUEST.TABLE_NAME, projection, null, null, null, null, null
            )

            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {
                    listGuest.add(
                        GuestModel(
                            cursor.getInt(cursor.getColumnIndex(Constants.GUEST.COLUMNS.ID)),
                            cursor.getString(cursor.getColumnIndex(Constants.GUEST.COLUMNS.NAME)),
                            cursor.getInt(cursor.getColumnIndex(Constants.GUEST.COLUMNS.PRESENCE)) == 1
                        )
                    )
                }
            }

            cursor?.close()
            listGuest

        } catch (e: Exception) {
             listGuest

        }
    }

    fun getGuest(id: Int): GuestModel? {
        var guest: GuestModel? = null

        return try {
            val dataBase = guestDataBase.readableDatabase
            val projection = arrayOf(
                Constants.GUEST.COLUMNS.NAME,
                Constants.GUEST.COLUMNS.PRESENCE
            )
            val selection = Constants.GUEST.COLUMNS.ID + " = ?"
            val args = arrayOf(id.toString())

            val cursor = dataBase.query(
                Constants.GUEST.TABLE_NAME, projection, selection, args, null, null, null
            )

            // Verifica se existem dados no cursor
            if (cursor != null && cursor.count > 0) {
                cursor.moveToFirst()
                guest = GuestModel(
                    id,
                    cursor.getString(cursor.getColumnIndex(Constants.GUEST.COLUMNS.NAME)),
                    cursor.getInt(cursor.getColumnIndex(Constants.GUEST.COLUMNS.PRESENCE)) == 1
                )

            }

            cursor?.close()
            guest

        } catch (e: Exception) {
            guest
        }

    }

    fun getAllPresent(): List<GuestModel> {
        val listGuest : MutableList<GuestModel> = ArrayList()

        return try {
            val dataBase = guestDataBase.readableDatabase
            val cursor = dataBase.rawQuery(
                "SELECT id, name, presence FROM Guest WHERE presence = 1", null
            )

            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {
                    listGuest.add(
                        GuestModel(
                            cursor.getInt(cursor.getColumnIndex(Constants.GUEST.COLUMNS.ID)),
                            cursor.getString(cursor.getColumnIndex(Constants.GUEST.COLUMNS.NAME)),
                            cursor.getInt(cursor.getColumnIndex(Constants.GUEST.COLUMNS.PRESENCE)) == 1
                        )
                    )
                }
            }

            cursor?.close()
            listGuest
        } catch (e: Exception) {
            listGuest
        }
    }

    fun getAllAbsent(): List<GuestModel> {
        val listGuest = mutableListOf<GuestModel>()

        try {
            val cursor = guestDataBase.readableDatabase.rawQuery(
                "SELECT id, name, presence FROM Guest WHERE presence = 0", null
            )

            if (cursor != null && cursor.count > 0) {
                while (cursor.moveToNext()) {
                    listGuest.add(
                        GuestModel(
                            cursor.getInt(cursor.getColumnIndex(Constants.GUEST.COLUMNS.ID)),
                            cursor.getString(cursor.getColumnIndex(Constants.GUEST.COLUMNS.NAME)),
                            cursor.getInt(cursor.getColumnIndex(Constants.GUEST.COLUMNS.PRESENCE)) == 1
                        )
                    )
                }
            }

            cursor.close()
        } catch (e: Exception) {
            return listGuest

        }
        return listGuest

    }
    */

}