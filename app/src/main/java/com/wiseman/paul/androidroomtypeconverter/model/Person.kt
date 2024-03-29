package com.wiseman.paul.androidroomtypeconverter.model

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_table")
data class Person(
val firstName: String,
val lastName: String,
val profilePhoto: Bitmap
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}