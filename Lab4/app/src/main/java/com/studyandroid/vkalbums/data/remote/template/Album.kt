package com.studyandroid.vkalbums.data.remote.template

import com.google.gson.annotations.SerializedName

data class Album(
    val id: Long,
    @SerializedName("owner_id")
    val userId: Long,
    val size: Long,
    val title: String,
    @SerializedName("thumb_id")
    val thumbId: Long,
    @SerializedName("sizes")
    val thumbSizes: List<Size>,
    var thumbUrl: String = "",
)
