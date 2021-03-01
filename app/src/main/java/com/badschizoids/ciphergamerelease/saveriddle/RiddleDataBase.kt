package com.badschizoids.ciphergamerelease.saveriddle

import androidx.room.Database
import androidx.room.RoomDatabase
import com.badschizoids.ciphergamerelease.tools.SolvedRiddle

@Database(entities = [SolvedRiddle::class], version = 1)
abstract class RiddleDataBase : RoomDatabase(){
    abstract fun solvedRiddleDao(): SolvedRiddleDao
}