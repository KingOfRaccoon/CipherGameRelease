package com.badschizoids.ciphergamerelease

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.badschizoids.ciphergamerelease.R

class ChatFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater,
                  container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_chat, container, false)




        return view
    }
}