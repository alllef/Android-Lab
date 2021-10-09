package com.github.alllef.androidlab1

import android.view.View
import android.widget.Button
import android.widget.TextView

class ButtonManager(var textView: TextView, var okButton: Button, var cancelButton: Button) {
    init {
        okButton.setOnClickListener {
            onOkButtonClicked()
        }
        cancelButton.setOnClickListener {

        }
    }

    private fun onOkButtonClicked() {

    }

    private fun onCancelButtonClicked() {
        textView.text = ""
    }
}