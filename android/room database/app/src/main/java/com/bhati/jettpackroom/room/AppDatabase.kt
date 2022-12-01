package com.bhati.jettpackroom.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Employee::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao(): EmployeeDao

    companion object {
        private var appDatabase: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            var db: AppDatabase? = null
            synchronized(this) {
                db = Room.databaseBuilder(context, AppDatabase::class.java, "Company").build()

            }
            return db!!
        }
    }


}