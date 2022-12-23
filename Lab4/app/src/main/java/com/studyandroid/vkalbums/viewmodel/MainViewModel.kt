package com.studyandroid.vkalbums.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.studyandroid.vkalbums.data.remote.template.Album
import com.studyandroid.vkalbums.data.remote.template.Photo
import com.studyandroid.vkalbums.data.remote.template.User
import com.studyandroid.vkalbums.data.remote.template.vkResponses.VkItems
import com.studyandroid.vkalbums.data.remote.template.vkResponses.VkResponse
import com.studyandroid.vkalbums.data.remote.template.vkResponses.VkResponseList
import com.studyandroid.vkalbums.data.remote.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Repository()

    val getUserOriginalIdResponse: MutableLiveData<Response<VkResponseList<User>>> =
        MutableLiveData()
    val getUsersAlbumsListResponse: MutableLiveData<Response<VkResponse<VkItems<Album>>>> =
        MutableLiveData()
    val getAlbumPhotosListResponse: MutableLiveData<Response<VkResponse<VkItems<Photo>>>> =
        MutableLiveData()

    fun getUserOriginalId(userId: String) {
        viewModelScope.launch {
            getUserOriginalIdResponse.postValue(repository.getUserOriginalId(userId))
        }
    }

    fun getUsersAlbumsList(ownerId: Long) {
        viewModelScope.launch {
            getUsersAlbumsListResponse.postValue(repository.getUsersAlbumsList(ownerId))
        }
    }

    fun getAlbumPhotosList(userId: Long, albumId: String, offset: Int, count: Int?) {
        viewModelScope.launch {
            getAlbumPhotosListResponse.postValue(
                repository.getAlbumPhotosList(
                    userId,
                    albumId,
                    offset,
                    count
                )
            )
        }
    }
}
