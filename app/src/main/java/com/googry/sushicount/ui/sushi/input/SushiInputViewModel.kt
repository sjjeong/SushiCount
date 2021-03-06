package com.googry.sushicount.ui.sushi.input

import android.app.Application
import android.databinding.ObservableField
import com.googry.sushicount.base.BaseViewModel
import com.googry.sushicount.ext.formatDateTime
import com.googry.sushicount.network.model.KakaoSearchResponse
import java.util.*

/**
 * Created by seokjunjeong on 2018. 5. 20..
 */
class SushiInputViewModel(application: Application)
    : BaseViewModel(application) {

    val dateTime = ObservableField<String>()
    val sushiStore = ObservableField<KakaoSearchResponse.Document>()

    val calendar = Calendar.getInstance()

    init {
        createDateTimeString()
    }

    fun setCalendar(year: Int,
                    month: Int,
                    dayOfMonth: Int,
                    hourOfDay: Int,
                    minute: Int) {
        calendar.run {
            set(Calendar.YEAR, year)
            set(Calendar.MONTH, month)
            set(Calendar.DAY_OF_MONTH, dayOfMonth)
            set(Calendar.HOUR_OF_DAY, hourOfDay)
            set(Calendar.MINUTE, minute)
        }
        createDateTimeString()
    }

    private fun createDateTimeString() {
        dateTime.set(calendar.time.formatDateTime(getApplication()))
    }

    // DataBinding Function
    fun save() {

    }


}