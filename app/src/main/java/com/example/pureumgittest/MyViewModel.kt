package com.example.pureumgittest

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.DomainAccessToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
//import java.lang.Exception
import javax.inject.Inject
import kotlin.Exception

/**
 * 2022-11-28
 * pureum
 */

@HiltViewModel
class MyViewModel @Inject constructor(
    private val tokenUseCase: TokenUseCase,
    //private val userUseCase: UserUseCase
) :ViewModel() {

    private val _accessToken = MutableLiveData<DomainAccessToken>()
    val accessToken: LiveData<DomainAccessToken>
        get() = _accessToken

    private val _UserData = MutableLiveData<DomainAccessToken>()
    val UserData: LiveData<DomainAccessToken>
        get() = _UserData

    fun viewModelGetAccessToken(code: String) {
        Log.e("TAG", "getAccessToken: start", )
        viewModelScope.launch {
            try {
                _accessToken.value = tokenUseCase.getToken(BuildConfig.GIT_ID, BuildConfig.GIT_SECRET, code)
            } catch (e: Exception) {
                Log.e("TAG", "getAccessToken: error $e")
            }
        }
    }

    fun viewModelGetUserData(token: String){
        Log.e("TAG", "getAccessToken: start", )
        viewModelScope.launch {
            try{

            }catch (e:Exception){

            }
        }
    }
}

