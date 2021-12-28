package com.github.alllef.androidlab1.fragment

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.github.alllef.androidlab1.R
import com.github.alllef.androidlab1.RadioGroupManager

class EditTextFragment : Fragment(R.layout.fragment_edit_text) {
    public interface OkButtonFragmentListener {
        fun onOkButtonClicked()
    }

    lateinit var okButton: Button
    lateinit var radioGroupManager: RadioGroupManager
    lateinit var okButtonFragmentListener: OkButtonFragmentListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_text, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        okButton = view.findViewById(R.id.ok)
        radioGroupManager = RadioGroupManager(view.findViewById(R.id.group))
        okButton.setOnClickListener { okButtonFragmentListener.onOkButtonClicked() }
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        okButtonFragmentListener = activity as OkButtonFragmentListener
    }

    public fun getFontName(): String {
        val radioButtonId: Int = radioGroupManager.getCheckedRadioButton()
        val radioButton: RadioButton = view?.findViewById(radioButtonId) as RadioButton
        return radioButton.text.toString()
    }

    public fun getFontId(): Int {
        val fontId = when (getFontName()) {
            "times_new_roman" -> R.font.toms_new_roman_eawr
            "arial" -> R.font.arial_narrow
            "comic_sans" -> R.font.sans_comic_sans_regular
            else -> println("what is it")
        }

        return fontId as Int
    }

    public fun getText(): Editable? {
        val editText: EditText? = view?.findViewById(R.id.text_to_edit)
        return editText?.text
    }
}