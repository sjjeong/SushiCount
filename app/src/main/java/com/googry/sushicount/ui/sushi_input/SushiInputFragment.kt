package com.googry.sushicount.ui.sushi_input

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.googry.sushicount.R
import com.googry.sushicount.base.BaseFragment
import com.googry.sushicount.databinding.SushiInputFragmentBinding
import java.util.*
import javax.inject.Inject

/**
 * Created by seokjunjeong on 2018. 5. 20..
 */
class SushiInputFragment
    : BaseFragment<SushiInputFragmentBinding>(R.layout.sushi_input_fragment) {

    @Inject
    lateinit var sushiInputViewModel: SushiInputViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            vm = sushiInputViewModel
            v = this@SushiInputFragment
        }
    }

    // DataBinding Function
    fun showDateTimePicker(calendar: Calendar) {
        DatePickerDialog(context,
                { _, year, month, dayOfMonth ->
                    TimePickerDialog(context,
                            { _, hourOfDay, minute ->
                                sushiInputViewModel.setCalendar(
                                        year, month, dayOfMonth, hourOfDay, minute
                                )
                            },
                            calendar[Calendar.HOUR_OF_DAY],
                            calendar[Calendar.MINUTE],
                            false).show()
                },
                calendar[Calendar.YEAR],
                calendar[Calendar.MONTH],
                calendar[Calendar.DAY_OF_MONTH]
        ).show()
    }

    // DataBinding Function
    fun showMarketDetail(){
        Toast.makeText(context, "showMarketDetail", Toast.LENGTH_SHORT).show()
    }

}