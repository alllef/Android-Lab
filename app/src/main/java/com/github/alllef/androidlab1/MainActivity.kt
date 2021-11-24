package com.github.alllef.androidlab1

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    // private lateinit var binding: ResultProfileBinding
    lateinit var radioGroup: RadioGroup
    lateinit var okButton: Button
    lateinit var editText: EditText
    lateinit var radioGroupManager: RadioGroupManager

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_view, EditTextFragment())
            .commit()

        okButton = findViewById(R.id.ok)
        editText = findViewById(R.id.text_to_edit)
        radioGroupManager = RadioGroupManager(findViewById(R.id.group))

        okButton.setOnClickListener {
            onOkButtonClicked()
        }
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

        val textViewFragment: Fragment = TextViewFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container_view, textViewFragment)
            .commit()

        val cancelButton: Button = findViewById(R.id.cancel)

        cancelButton.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .remove(EditTextFragment())
                .commit()
        }

        val textView: TextView = findViewById(R.id.converted_text)
        textView.typeface = resources.getFont(fontId as Int)
        textView.text = editText.text
    }
}