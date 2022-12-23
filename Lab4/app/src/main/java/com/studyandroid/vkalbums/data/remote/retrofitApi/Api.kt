package com.studyandroid.vkalbums.data.remote.retrofitApi

import com.studyandroid.vkalbums.data.remote.template.Album
import com.studyandroid.vkalbums.data.remote.template.Photo
import com.studyandroid.vkalbums.data.remote.template.User
import com.studyandroid.vkalbums.data.remote.template.vkResponses.VkItems
import com.studyandroid.vkalbums.data.remote.template.vkResponses.VkResponse
import com.studyandroid.vkalbums.data.remote.template.vkResponses.VkResponseList
import retrofit2.Response
import retrofit2.http.*

interface Api {

    @GET("users.get")
    suspend fun getUserOriginalId(
        @Query("user_id") userId: String,
    ): Response<VkResponseList<User>>

    @GET("photos.getAlbums")
    suspend fun getUsersAlbumsList(
        @Query("owner_id") ownerId: Long,
        // With manually created albums return system albums such as 'Saved images' etc.
        @Query("need_system") needSystem: Int = 1,
        @Query("need_covers") needCovers: Int = 1,
        @Query("photo_sizes") photoSizes: Int = 1,
    ): Response<VkResponse<VkItems<Album>>>

    @GET("photos.get")
    suspend fun getAlbumPhotosList(
        @Query("owner_id") ownerId: Long,
        // albumId takes String because of special forms of request like 'wall' or 'saved'
        @Query("album_id") albumId: String,
        @Query("offset") offset: Int,
        @Query("count") count: Int? = null,
        @Query("rev") rev: Int = 1,
    ): Response<VkResponse<VkItems<Photo>>>
}
