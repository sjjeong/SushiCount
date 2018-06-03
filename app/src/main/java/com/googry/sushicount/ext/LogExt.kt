package com.googry.sushicount.ext

import android.util.Log
import com.googry.sushicount.BuildConfig

inline fun LogE(msg: String?) {
    if (BuildConfig.DEBUG) {
        Log.e("googry", msg)
    }
}