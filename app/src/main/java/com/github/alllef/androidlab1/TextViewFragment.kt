package com.github.alllef.androidlab1

import android.os.Build
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi

class TextViewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val cancelButton: Button? = view?.findViewById(R.id.cancel)

        cancelButton?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .remove(this)
                .commit()
        }

        return inflater.inflate(R.layout.fragment_text_view, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    public fun addText(fontId: Int, text: Editable?) {

        val textView: TextView? = view?.findViewById(R.id.converted_text)
        textView?.typeface = resources.getFont(fontId as Int)
        textView?.text = text
    }
}