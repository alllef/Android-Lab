package com.github.alllef.androidlab1.sqllite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class TextFontDbHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_DELETE_RECORD)
        db.execSQL(SQL_CREATE_RECORD)
        println("gchi")
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onCreate(db)
    }

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "TextFont.db"

        public const val SQL_CREATE_RECORD =
            """CREATE TABLE ${TextFontContract.Record.TABLE_NAME} (
                ${BaseColumns._ID} INTEGER PRIMARY KEY,
                ${TextFontContract.Record.COLUMN_TEXT} TEXT,
                ${TextFontContract.Record.COLUMN_FONT} TEXT)"""

        public const val SQL_DELETE_RECORD =
            "DROP TABLE IF EXISTS ${TextFontContract.Record.TABLE_NAME}"
    }


}