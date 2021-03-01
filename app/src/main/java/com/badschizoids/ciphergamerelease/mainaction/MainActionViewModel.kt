package com.badschizoids.ciphergamerelease.mainaction

import android.util.Log
import androidx.lifecycle.ViewModel
import com.badschizoids.ciphergamerelease.network.DataFireStore
import com.badschizoids.ciphergamerelease.tools.User
import com.badschizoids.ciphergamerelease.Mem

class MainActionViewModel: ViewModel() {
    var messageAnswer = ""
    fun init(){
        DataFireStore().getAllMemes().addOnCompleteListener {
            if (it.isSuccessful){
                val listMemes = mutableListOf<Mem>()
                val list = it.result?.get("mem") as List<String>
                for (i in list){
                    listMemes.add(Mem(i))
                }
                User.mutableLiveData.postValue(listMemes)
            }
            else
                Log.e("Data", it.exception?.message.toString())
        }
    }
}