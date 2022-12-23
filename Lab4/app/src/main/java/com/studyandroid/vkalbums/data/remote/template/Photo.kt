package com.studyandroid.vkalbums.data.remote.template

import com.google.gson.annotations.SerializedName

data class Photo(
    val id: Long,
    @SerializedName("album_id")
    val albumId: Long,
    @SerializedName("owner_id")
    val userId: Long,
    val sizes: List<Size>,
    var photoUrl: String = "",
)
