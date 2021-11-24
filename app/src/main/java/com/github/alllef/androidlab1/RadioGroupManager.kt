package com.github.alllef.androidlab1

import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup

class RadioGroupManager(val radioGroup: RadioGroup) {

    public fun getCheckedRadioButton(): Int {
        val buttonId: Int = radioGroup.checkedRadioButtonId
        return buttonId
    }
}