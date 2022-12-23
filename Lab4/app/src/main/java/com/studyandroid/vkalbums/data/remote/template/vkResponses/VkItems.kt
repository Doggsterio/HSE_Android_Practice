package com.studyandroid.vkalbums.data.remote.template.vkResponses

data class VkItems<T>(
    val count: Long,
    val items: List<T>,
)
