package com.badschizoids.ciphergamerelease

import android.content.Context
import android.preference.PreferenceManager
import com.badschizoids.ciphergamerelease.tools.AlertsDialog
import com.badschizoids.ciphergamerelease.tools.User
import com.badschizoids.ciphergamerelease.ciphers.*

class GenerateEncryptMessage(val context: Context) {
    val preferences = PreferenceManager.getDefaultSharedPreferences(context)
    fun generateMessage(string: String, level: Int): String {
        var message = string
        val ciphers = mutableListOf(CaesarCipher(), ViginerCipher(), ReverseCipher())
        var count = 0
        when(level){
            in (0..2) ->{
                count = 1
            }
            in (3..5) ->{
                count = 2
            }
        }
        for (i in 0 until count){
            val cipher = ciphers.random()
            when(cipher){
                is CaesarCipher ->{
                    val beenThisCipher = preferences.getString(preferences_caesar, "No")
                    if (beenThisCipher == "No"){
                        User.helps.add(
                                AlertsDialog().createCaesarAlertDialog(context)
                        )
                        preferences.edit().putString(preferences_caesar, "Yes").apply()
                    }
                }
                is ViginerCipher ->{
                    val beenThisCipher = preferences.getString(preferences_viginer, "No")
                    if (beenThisCipher == "No"){
                        User.helps.add(
                                AlertsDialog().createViginerAlertDialog(context)
                        )
                        preferences.edit().putString(preferences_viginer, "Yes").apply()
                    }
                }
                is ReverseCipher ->{

                }
                is ByteCipher ->{

                }
                is SpinnerCipher ->{

                }
            }
            message = cipher.encrypt(message)
        }
        return message
    }
    companion object{
        val preferences_viginer = "Viginer"
        val preferences_caesar = "Caesar"
        val preferences_reverse = "Reverse"
        val preferences_byte = "Byte"
        val preferences_spinner = "Spinner"
    }
}