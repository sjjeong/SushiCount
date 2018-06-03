package com.googry.sushicount.network.model


data class KakaoSearchResponse(
        val meta: Meta,
        val documents: List<Document>
) {

    data class Document(
            val store_url: String,
            val category_group_name: String,
            val place_name: String,
            val distance: String,
            val address_name: String,
            val road_address_name: String,
            val id: String,
            val phone: String,
            val category_group_code: String,
            val category_name: String,
            val x: String,
            val y: String
    )

    data class Meta(
            val same_name: SameName,
            val pageable_count: Int,
            val total_count: Int,
            val is_end: Boolean
    )

    data class SameName(
            val region: List<Any>,
            val keyword: String,
            val selected_region: String
    )
}