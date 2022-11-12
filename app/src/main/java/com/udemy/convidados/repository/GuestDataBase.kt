package com.udemy.convidados.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.udemy.convidados.model.GuestModel

@Database(entities = [GuestModel::class], version = 1)
abstract class GuestDatabase : RoomDatabase() {

    abstract fun guestDAO(): GuestDAO

    companion object {
        private lateinit var INSTANCE: GuestDatabase

        fun getDataBase(context: Context): GuestDatabase {
            if (!::INSTANCE.isInitialized) {
                synchronized(GuestDatabase::class){
                    INSTANCE = Room.databaseBuilder(context, GuestDatabase::class.java, "guestdb")
                        .addMigrations(MIGRATION)
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

        private val MIGRATION : Migration = object : Migration(1 , 2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("DELETE FROM Guest")
            }

        }

    }

}

/*
class GuestDataBase(context: Context) : SQLiteOpenHelper(context, NAME, null, VERSION) {

    /**
     * Método executado somente uma vez quando o acesso ao banco de dados é feito pela primeira vez
     */
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_GUEST)
    }

    /**
     * Método executado quando a versão do DATABASE_VERSION é alterada
     * Dessa maneira, a aplicação sabe que o banco de dados foi alterado e é necessário rodar o script de update
     */
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) { }

    companion object {
        private const val NAME = "Convidados.db"
        private const val VERSION = 1

        private const val CREATE_TABLE_GUEST =
            ("create table " + Constants.GUEST.TABLE_NAME + " ("
                    + Constants.GUEST.COLUMNS.ID + " integer primary key autoincrement, "
                    + Constants.GUEST.COLUMNS.NAME + " text, "
                    + Constants.GUEST.COLUMNS.PRESENCE + " integer);")
    }
}
*/
