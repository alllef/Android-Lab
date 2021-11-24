package com.github.alllef.androidlab1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class BlankFragment : Fragment(R.layout.fragment_blank) {
    lateinit var radioGroupManager: RadioGroupManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
      radioGroupManager = RadioGroupManager(view.findViewById(R.id.group))

    }
}