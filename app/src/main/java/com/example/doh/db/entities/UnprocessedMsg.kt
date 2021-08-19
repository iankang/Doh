package com.example.doh.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UnprocessedMsg(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val address:String?,
    val date:String?,
    val subject: String?
)
