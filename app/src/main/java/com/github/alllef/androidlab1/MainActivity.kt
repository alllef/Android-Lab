package com.github.alllef.androidlab1

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    // private lateinit var binding: ResultProfileBinding

    lateinit var radioGroup: RadioGroup
    lateinit var okButton: Button
    lateinit var cancelButton: Button
    lateinit var editText: EditText
    lateinit var textView: TextView
    lateinit var radioGroupManager: RadioGroupManager

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        okButton = findViewById(R.id.ok)
        cancelButton = findViewById(R.id.cancel)
        editText = findViewById(R.id.text_to_edit)
        textView = findViewById(R.id.converted_text)
        radioGroupManager = RadioGroupManager(findViewById(R.id.group))

        okButton.setOnClickListener {
            onOkButtonClicked()
        }

        cancelButton.setOnClickListener {
            onCancelButtonClicked()
        }
    }

    private fun onCancelButtonClicked() {
        textView.text = ""
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun onOkButtonClicked() {
        val radioButtonId: Int = radioGroupManager.getCheckedRadioButton()
        val radioButton: RadioButton = findViewById(radioButtonId) as RadioButton
        val fontId = when (radioButton.text) {
            "times_new_roman" -> R.font.toms_new_roman_eawr
            "arial" -> R.font.arial_narrow
            "comic_sans" -> R.font.sans_comic_sans_regular
            else -> println("what is it")
        }

        textView.typeface = resources.getFont(fontId as Int)
        textView.text = editText.text
    }
}