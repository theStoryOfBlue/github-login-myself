package com.example.pureumgittest

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

/**
 * 2022-11-28
 * pureum
 */
class MyViewModel :ViewModel() {

    private val api by lazy {RepoImpl()}

    private val _accessToken = MutableLiveData<AccessToken>()
    val accessToken: LiveData<AccessToken>
        get() = _accessToken

    fun viewModeGetAccessToken(code: String) {
        Log.e("TAG", "getAccessToken: start", )
        viewModelScope.launch {
            try {
                _accessToken.value = api.getAccessToken(BuildConfig.GIT_ID, BuildConfig.GIT_SECRET, code)
            } catch (e: Exception) {
                Log.e("TAG", "getAccessToken: error $e")
            }
        }
    }
}

