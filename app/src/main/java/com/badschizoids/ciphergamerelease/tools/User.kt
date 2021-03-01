package com.badschizoids.ciphergamerelease.tools

import android.app.AlertDialog
import androidx.lifecycle.MutableLiveData
import com.badschizoids.ciphergamerelease.Mem

object User {
    private val list = listOf<Mem>()
    val mutableLiveData = MutableLiveData(list)

    val helps = mutableListOf<AlertDialog>()
}