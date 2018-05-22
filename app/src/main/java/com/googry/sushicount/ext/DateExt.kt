package com.googry.sushicount.ext

import android.content.Context
import com.googry.sushicount.R
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by seokjunjeong on 2018. 5. 20..
 */

fun Date.formatDateTime(context: Context): String =
        SimpleDateFormat(context.getString(R.string.date_time_format), Locale.getDefault())
                .format(this)