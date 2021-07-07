package com.raywenderlich.extensions

import android.app.Dialog
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import androidx.core.content.ContextCompat

fun TextView.putDifferentColorStrings(stringArr: Array<String>, colorArr: Array<Int>){
    val spannable = SpannableString(stringArr.joinToString(""))

    var startIndex = 0
    for (i in stringArr.indices) {
        spannable.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(context, colorArr[i])),
            startIndex, startIndex + stringArr[i].length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        startIndex += stringArr[i].length
    }
    text = spannable

}


fun Dialog.setUp(resurce:Int){

    window!!.setBackgroundDrawableResource(android.R.color.transparent)
    window!!.requestFeature(Window.FEATURE_NO_TITLE)
    setContentView(resurce)
    val params = window!!.attributes
    params.width = WindowManager.LayoutParams.MATCH_PARENT
    params.height = WindowManager.LayoutParams.WRAP_CONTENT


}

