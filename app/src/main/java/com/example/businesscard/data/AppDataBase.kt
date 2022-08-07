package com.example.businesscard.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BusinessCardEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getBusinessCardDao() : BusinessCardDao

    companion object{
        @Volatile
        private var INSTANCE : AppDataBase? = null
        fun getDataBase(context : Context) : AppDataBase {

            return INSTANCE ?: synchronized(this){
                val  instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "businessCard_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}