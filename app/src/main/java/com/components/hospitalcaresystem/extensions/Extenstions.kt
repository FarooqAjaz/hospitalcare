package com.components.hospitalcaresystem.extensions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.Dp
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Composable
fun SpacerHeight(
    height: Dp,
    modifier:Modifier=Modifier
) {
    Spacer(modifier = modifier.height(height))
}

@Composable
fun SpacerWidth(
    width: Dp,
    modifier:Modifier=Modifier
) {
    Spacer(modifier = modifier.width(width))
}

@Composable
fun SpaceBetweenField(
    modifier:Modifier = Modifier,
    height: Dp = 1.hpr
) {
    Spacer(modifier = modifier.height(height))
}

fun Modifier.noRippleClickable(onClick: () -> Unit): Modifier = composed {
    this.clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}



// Convert a date string to milliseconds
fun dateToMillis(dateString: String?,dateFormat: String?="dd MMMM, yyyy"): Long? {
    val dateFormator = SimpleDateFormat(dateFormat, Locale.getDefault())
    return try {
        dateString?.let {
            val date = dateFormator.parse(it)
            date?.time
        }
    } catch (e: Exception) {
        null
    }
}

// Convert milliseconds to formatted date string
fun millisToDate(millis: Long, dateFormat: String?="dd MMMM, yyyy"): String {
    val dateFormator = SimpleDateFormat(dateFormat, Locale.getDefault())
    val date = Date(millis)
    return dateFormator.format(date)
}


//TODO : Will be moved to the DateUtil Class
fun getFormattedDate(dateInMillis: Long?, format: String): String {
    val formatter = SimpleDateFormat(format, Locale.getDefault())
    return if (dateInMillis != null) {
        formatter.format(Date(dateInMillis))
    } else {
        ""
    }
}

fun getPreviousMonthDate(currentDateInMillis: Long, count: Int): Long {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = currentDateInMillis
    calendar.add(Calendar.MONTH, count)
    return calendar.timeInMillis
}

