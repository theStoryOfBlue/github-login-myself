package com.example.pureumgittest

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.DomainAccessToken
import com.example.domain.DomainRepo
import com.example.domain.DomainUser
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
    private val userUseCase: UserUseCase,
    private val repoUseCase: RepoUseCase
) :ViewModel() {

    val _accessToken = MutableLiveData<DomainAccessToken>()
    val accessToken: LiveData<DomainAccessToken>
        get() = _accessToken

    private val _userData = MutableLiveData<DomainUser>()
    val userData: LiveData<DomainUser>
        get() = _userData

    private val _repo = MutableLiveData<List<DomainRepo>>()
    val repo: MutableLiveData<List<DomainRepo>>
        get() = _repo

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

    fun viewModelGetUserData(){
        Log.e("TAG", "getAccessToken: start", )
        viewModelScope.launch {
            try{
                Log.e("TAG", "viewModelGetUserData: ${_accessToken.value?.accessToken}", )
                _userData.value = userUseCase.getUser("bearer ${_accessToken.value?.accessToken}")
            }catch (e:Exception){
                Log.e("TAG", "getAccessToken error : $e")
            }
        }
    }

    fun viewModelGetRepo(){
        viewModelScope.launch {
            try {
                _repo.value = repoUseCase.getRepo("bearer ${_accessToken.value?.accessToken}")
            }catch (e:Exception){
                Log.e("TAG", "viewModelGetRepo err : $e", )
            }
        }
    }
}

