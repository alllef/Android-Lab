package com.github.alllef.androidlab1.sqllite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class TextFontContract{

    object Record : BaseColumns {
        const val TABLE_NAME = "record"
        const val COLUMN_TEXT_TITLE = "text"
        const val COLUMN_FONT = "font"
    }

}