package com.example.businesscard.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BusinessCardEntity(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val name : String,
    val company : String,
    val phone : String,
    val email : String,
    var color : String?
)