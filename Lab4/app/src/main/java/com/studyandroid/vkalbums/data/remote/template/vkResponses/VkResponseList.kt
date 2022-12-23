package com.studyandroid.vkalbums.data.remote.template.vkResponses

import com.google.gson.annotations.SerializedName

data class VkResponseList<T>(
    @SerializedName("response")
    val data: List<T>? = null,
    @SerializedName("error")
    val error: VkError? = null,
)
