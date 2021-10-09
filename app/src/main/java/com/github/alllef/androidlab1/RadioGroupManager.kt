package com.github.alllef.androidlab1

import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup

class RadioGroupManager(val radioGroup: RadioGroup) {

    public fun getFontName(): String {
        val button: RadioButton = radioGroup.focusedChild as RadioButton
        return button.text.toString()
    }
}