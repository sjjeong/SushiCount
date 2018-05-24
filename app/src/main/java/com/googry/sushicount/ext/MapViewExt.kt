package com.googry.sushicount.ext

import android.databinding.BindingAdapter
import com.googry.sushicount.data.model.SushiMarket
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

/**
 * Created by seokjunjeong on 2018. 5. 25..
 */

@BindingAdapter("sushiMarket")
fun MapView.setSushiMarket(sushiMarket: SushiMarket) {
    MapPoint.mapPointWithGeoCoord(sushiMarket.latitude, sushiMarket.longitude).let {
        setMapCenterPointAndZoomLevel(it, 1, false)
        MapPOIItem().apply {
            itemName = sushiMarket.name
            mapPoint = it
        }.let {
            addPOIItem(it)
            selectPOIItem(it, true)
        }
    }
}