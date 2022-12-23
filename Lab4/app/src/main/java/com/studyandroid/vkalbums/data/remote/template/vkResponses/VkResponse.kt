package com.studyandroid.vkalbums.data.remote.template.vkResponses

import com.google.gson.annotations.SerializedName

data class VkResponse<T>(
    @SerializedName("response")
    val data: T? = null,
    @SerializedName("error")
    val error: VkError? = null,
)
