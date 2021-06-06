package com.wiseman.paul.androidroomtypeconverter.repository

import androidx.lifecycle.LiveData
import com.wiseman.paul.androidroomtypeconverter.data.MyDao
import com.wiseman.paul.androidroomtypeconverter.model.Person

class MyRepository(private val myDao: MyDao) {
    val readPerson: LiveData<List<Person>> = myDao.readPerson()

    suspend fun insertPerson(person: Person){
        myDao.insertPerson(person)
    }
}