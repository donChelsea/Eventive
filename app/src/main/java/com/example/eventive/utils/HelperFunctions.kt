package com.example.eventive.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
fun convertDayAndTime(date: String): Pair<String, String> {
    val format: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.getDefault())
    var day = ""
    var time = ""
    try {
        val dateParsed = format.parse(date)
        println(dateParsed)
        day = dateParsed.toString().substring(4..9)
        time = dateParsed.toString().substring(11..15)
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return Pair(day, time)
}