package com.studyandroid.vkalbums.data.remote.retrofitApi

import java.io.IOException

class NoConnectivityException : IOException() {

    override fun getLocalizedMessage(): String {
        return "No internet connection"
    }
}
