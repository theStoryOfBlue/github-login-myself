package com.example.pureumgittest

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 2022-11-30
 * pureum
 */
class RepoImpl : GitAPI_Repo {
    override suspend fun getAccessToken(
        clientID:String,
        clientSecret:String,
        code: String
    ):AccessToken {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.domainURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build() // Retrofit Object Create
            .create(GitAPI_Repo::class.java).getAccessToken(clientID, clientSecret, code)
    }
}