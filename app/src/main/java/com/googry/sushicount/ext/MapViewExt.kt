package com.googry.sushicount.ext

import android.databinding.BindingAdapter
import com.googry.sushicount.network.model.KakaoSearchResponse
import net.daum.mf.map.api.MapPOIItem
import net.daum.mf.map.api.MapPoint
import net.daum.mf.map.api.MapView

/**
 * Created by seokjunjeong on 2018. 5. 25..
 */

@BindingAdapter("sushiStore")
fun MapView.setKakaoSearchResponse(sushiStore: KakaoSearchResponse.Document) {
    MapPoint.mapPointWithGeoCoord(sushiStore.y.toDouble(), sushiStore.x.toDouble()).let {
        setMapCenterPointAndZoomLevel(it, 1, false)
        MapPOIItem().apply {
            itemName = sushiStore.place_name
            mapPoint = it
        }.let {
            addPOIItem(it)
            selectPOIItem(it, true)
        }
    }
}