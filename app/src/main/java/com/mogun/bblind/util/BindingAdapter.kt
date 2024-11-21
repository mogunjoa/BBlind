package com.mogun.bblind.util

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.util.Date

@BindingAdapter("date")
fun TextView.setText(date: Date?) {
    text = DateUtil.convertPrintDateString(date)
}