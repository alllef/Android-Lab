package com.github.alllef.androidlab1.fragment

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.github.alllef.androidlab1.R

class TextViewFragment(val fontId: Int, val text: String) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_text_view, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val textView: TextView? = view.findViewById(R.id.converted_text)
        textView?.typeface = resources.getFont(fontId)
        textView?.text = text

        val cancelButton: Button = view.findViewById(R.id.cancel)
        cancelButton.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .remove(this)
                .commit()
        }
    }

}