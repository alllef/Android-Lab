package com.github.alllef.androidlab1.activity

import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.alllef.androidlab1.R
import com.github.alllef.androidlab1.sqllite.TextFontContract

class DbActivity : AppCompatActivity() {
    lateinit var db: SQLiteDatabase
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_db)

        db = savedInstanceState?.get("database") as SQLiteDatabase
        textView =findViewById(R.id.db_content)
        getData()
    }

    fun getData() {
        var starterText: String = ""
        val cursor = db.query(
            TextFontContract.Record.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            null
        )

        with(cursor) {
            while (moveToNext()) {
                val font = getString(getColumnIndexOrThrow(TextFontContract.Record.COLUMN_FONT))
                val title = getString(getColumnIndexOrThrow(TextFontContract.Record.COLUMN_TEXT))
                starterText = "$starterText$font $title\n"
            }

            if (starterText.isEmpty())
                starterText = "Any data hasn't retrieved"
        }

        textView.text = starterText
        cursor.close()
    }
}