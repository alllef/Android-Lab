package com.github.alllef.androidlab1

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import com.github.alllef.androidlab1.fragment.EditTextFragment
import com.github.alllef.androidlab1.fragment.TextViewFragment

class MainActivity : AppCompatActivity() {

    // private lateinit var binding: ResultProfileBinding
    lateinit var radioGroup: RadioGroup
    lateinit var okButton: Button
    lateinit var radioGroupManager: RadioGroupManager
    lateinit var ediTextFragment: EditTextFragment

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ediTextFragment = EditTextFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_edit_container_view, ediTextFragment, "edit_fragment")
            .commit()

        okButton = findViewById(R.id.ok)
        radioGroupManager = RadioGroupManager(findViewById(R.id.group))

        okButton.setOnClickListener {
            onOkButtonClicked()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun onOkButtonClicked() {

        val textViewFragment: TextViewFragment = TextViewFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_view_container_view, textViewFragment, "text_fragment")
            .commit()
    }

    public fun getFontId(): Int {
        val radioButtonId: Int = radioGroupManager.getCheckedRadioButton()
        val radioButton: RadioButton = findViewById(radioButtonId) as RadioButton
        val fontId = when (radioButton.text) {
            "times_new_roman" -> R.font.toms_new_roman_eawr
            "arial" -> R.font.arial_narrow
            "comic_sans" -> R.font.sans_comic_sans_regular
            else -> println("what is it")
        }

        return fontId as Int
    }
}