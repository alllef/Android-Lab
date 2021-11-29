package com.github.alllef.androidlab1

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment

class EditTextFragment : Fragment(R.layout.fragment_edit_text) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_text, container, false)
    }

    fun getEditedText(): Editable? {
        val editText: EditText? = view?.findViewById(R.id.text_to_edit)
        return editText?.text
    }
}