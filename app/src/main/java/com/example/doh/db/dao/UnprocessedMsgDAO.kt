package com.example.doh.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.doh.db.entities.UnprocessedMsg

@Dao
interface UnprocessedMsgDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllUnprocessedMessages(messages:List<UnprocessedMsg>)

    @Query("SELECT * FROM UnprocessedMsg")
    fun getAllUnprocessedMessages():LiveData<List<UnprocessedMsg>>
}