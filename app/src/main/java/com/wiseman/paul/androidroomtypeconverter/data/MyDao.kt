package com.wiseman.paul.androidroomtypeconverter.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wiseman.paul.androidroomtypeconverter.model.Person

@Dao
interface MyDao {
    @Query("SELECT * FROM my_table ORDER BY id ASC")
    fun readPerson(): LiveData<List<Person>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPerson(person: Person)
}