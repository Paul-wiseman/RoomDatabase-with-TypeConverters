package com.wiseman.paul.androidroomtypeconverter.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.wiseman.paul.androidroomtypeconverter.converter.Converters
import com.wiseman.paul.androidroomtypeconverter.model.Person

@Database(entities = [Person::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class MyDatabase:RoomDatabase() {
    abstract fun myDao(): MyDao

    companion object {
        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getDatabase(context: Context): MyDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                MyDatabase::class.java, "my_database"
            ).build()
    }
}