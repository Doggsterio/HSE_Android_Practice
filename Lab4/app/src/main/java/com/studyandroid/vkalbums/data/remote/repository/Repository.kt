package com.studyandroid.vkalbums.data.remote.repository

import android.util.Log
import com.studyandroid.vkalbums.data.remote.retrofitApi.NoConnectivityException
import com.studyandroid.vkalbums.data.remote.retrofitApi.RetrofitInstance
import com.studyandroid.vkalbums.data.remote.template.Album
import com.studyandroid.vkalbums.data.remote.template.Photo
import com.studyandroid.vkalbums.data.remote.template.User
import com.studyandroid.vkalbums.data.remote.template.vkResponses.VkItems
import com.studyandroid.vkalbums.data.remote.template.vkResponses.VkResponse
import com.studyandroid.vkalbums.data.remote.template.vkResponses.VkResponseList
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Response

class Repository {

    suspend fun getUserOriginalId(userId: String): Response<VkResponseList<User>> {
        return try {
            RetrofitInstance.api.getUserOriginalId(userId)
        } catch (e: NoConnectivityException) {
            Log.d("INTERNET", "Caught $e")
            Response.error(997, "$e".toResponseBody())
        }
    }

    suspend fun getUsersAlbumsList(ownerId: Long): Response<VkResponse<VkItems<Album>>> {
        return try {
            RetrofitInstance.api.getUsersAlbumsList(ownerId)
        } catch (e: NoConnectivityException) {
            Log.d("INTERNET", "Caught $e")
            Response.error(997, "$e".toResponseBody())
        }
    }

    suspend fun getAlbumPhotosList(
        ownerId: Long,
        albumId: String,
        offset: Int,
        count: Int?,
    ): Response<VkResponse<VkItems<Photo>>> {
        return try {
            RetrofitInstance.api.getAlbumPhotosList(ownerId, albumId, offset, count)
        } catch (e: NoConnectivityException) {
            Log.d("INTERNET", "Caught $e")
            Response.error(997, "$e".toResponseBody())
        }
    }
}
