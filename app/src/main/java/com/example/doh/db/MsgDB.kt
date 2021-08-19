package com.example.doh.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import com.example.doh.db.dao.UnprocessedMsgDAO
import com.example.doh.db.entities.UnprocessedMsg

@Database(
    entities = [UnprocessedMsg::class],
    version = 1,
    exportSchema = false
)
@TypeConverter(Converters::class)
abstract class MsgDB : RoomDatabase(){
    internal  abstract fun unprocessedDao(): UnprocessedMsgDAO
}