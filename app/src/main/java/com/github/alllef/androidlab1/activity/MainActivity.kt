package com.github.alllef.androidlab1.activity

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.annotation.RequiresApi
import com.github.alllef.androidlab1.R
import com.github.alllef.androidlab1.fragment.EditTextFragment
import com.github.alllef.androidlab1.fragment.TextViewFragment
import com.github.alllef.androidlab1.sqllite.TextFontContract
import com.github.alllef.androidlab1.sqllite.TextFontDbHelper

class MainActivity : AppCompatActivity(), EditTextFragment.OkButtonFragmentListener {
    lateinit var ediTextFragment: EditTextFragment
    lateinit var openButton: Button
    lateinit var database: SQLiteDatabase

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        database = TextFontDbHelper(this).writableDatabase
        database.execSQL(TextFontDbHelper.SQL_DELETE_RECORD)
        database.execSQL(TextFontDbHelper.SQL_CREATE_RECORD)

        ediTextFragment = EditTextFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_edit_container_view, ediTextFragment, "edit_fragment")
            .commit()

        val okButton: Button? = ediTextFragment.view?.findViewById(R.id.ok)
        val openButton: Button? = findViewById(R.id.open)

        openButton?.setOnClickListener {
            onOpenButtonClicked()
        }

        okButton?.setOnClickListener {
            onOkButtonClicked()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onOkButtonClicked() {
        createTextViewFragment()
        insertValue()
    }

    private fun onOpenButtonClicked() {
        val intent = Intent(this, DbActivity::class.java)
        startActivity(intent)
    }

    fun insertValue() {
        val values = ContentValues().apply {
            put(TextFontContract.Record.COLUMN_FONT, ediTextFragment.getFontName())
            put(TextFontContract.Record.COLUMN_TEXT, ediTextFragment.getText().toString())
        }
        val toast = Toast.makeText(this, "Nothing was saved. Value is empty", Toast.LENGTH_SHORT)

        if (!ediTextFragment.getText().toString().isEmpty()) {
            toast.setText("Saved successfully")
            val result = database.insert(TextFontContract.Record.TABLE_NAME, null, values)
        }

        toast.show()
    }

    fun createTextViewFragment() {
        val textViewFragment: TextViewFragment =
            TextViewFragment(ediTextFragment.getFontId(), ediTextFragment.getText().toString())

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_view_container_view, textViewFragment, "text_fragment")
            .commit()
    }
}