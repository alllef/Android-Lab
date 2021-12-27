package com.github.alllef.androidlab1.fragment

import android.os.Build
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.github.alllef.androidlab1.MainActivity
import com.github.alllef.androidlab1.R

class TextViewFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return inflater.inflate(R.layout.fragment_text_view, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val cancelButton: Button? = view.findViewById(R.id.cancel)

        cancelButton?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .remove(this)
                .commit()
        }
            val mainActivity: MainActivity = activity as MainActivity
            val editTextFragment =
                parentFragmentManager.findFragmentById(R.id.fragment_edit_container_view) as EditTextFragment

            val textToEdit: EditText? = editTextFragment.view?.findViewById(R.id.text_to_edit)
            addText(mainActivity.getFontId(), textToEdit?.text)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    public fun addText(fontId: Int, text: Editable?) {

        val textView: TextView? = view?.findViewById(R.id.converted_text)
        textView?.typeface = resources.getFont(fontId)
        textView?.text = text
    }
}