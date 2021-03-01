package com.badschizoids.ciphergamerelease.tools

import android.app.Application
import androidx.room.Room
import com.badschizoids.ciphergamerelease.saveriddle.RiddleDataBase

class CipherApplication: Application() {
    private lateinit var riddleDataBase: RiddleDataBase
    lateinit var instance : CipherApplication
    override fun onCreate() {
        super.onCreate()
        instance = this
        riddleDataBase = Room.databaseBuilder(
            this,
            RiddleDataBase::class.java,
            "database"
        )
            .build()
    }
    fun getDatabase() = riddleDataBase

    fun getInstanceApp() = instance
}