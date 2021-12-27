package com.github.alllef.androidlab1

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import com.github.alllef.androidlab1.fragment.EditTextFragment
import com.github.alllef.androidlab1.fragment.TextViewFragment
import com.github.alllef.androidlab1.sqllite.TextFontContract
import com.github.alllef.androidlab1.sqllite.TextFontDbHelper

class MainActivity : AppCompatActivity(), EditTextFragment.OkButtonFragmentListener,TextViewFragment.CancelButtonFragmentListener {
    lateinit var ediTextFragment: EditTextFragment

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ediTextFragment = EditTextFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_edit_container_view, ediTextFragment, "edit_fragment")
            .commit()

        val okButton: Button? = ediTextFragment.view?.findViewById(R.id.ok)
        okButton?.setOnClickListener {
            onOkButtonClicked()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
     override fun onOkButtonClicked() {
        val textViewFragment: TextViewFragment =
            TextViewFragment(ediTextFragment.getFontId(), ediTextFragment.getText().toString())

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_view_container_view, textViewFragment, "text_fragment")
            .commit()
    }

    override fun onCancelButtonClicked() {

    }
}