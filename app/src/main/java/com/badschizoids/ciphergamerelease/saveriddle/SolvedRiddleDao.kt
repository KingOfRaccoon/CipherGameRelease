package com.badschizoids.ciphergamerelease.saveriddle

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.badschizoids.ciphergamerelease.tools.SolvedRiddle

@Dao
interface SolvedRiddleDao {
    @Query("SELECT * FROM solvedriddle")
    fun getAllHistory():LiveData<List<SolvedRiddle>>

    @Insert
    suspend fun addSolvedRiddleDao(solvedRiddle: SolvedRiddle)
}