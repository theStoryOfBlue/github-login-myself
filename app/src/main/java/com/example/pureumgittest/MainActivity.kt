package com.example.pureumgittest

import android.accounts.AccountManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.browser.customtabs.CustomTabsIntent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.e("TAG", "onCreate: start", )

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        login(this)

//        val loginUrl = Uri.Builder().scheme("https").authority("github.com")
//            .appendPath("login")
//            .appendPath("oauth")
//            .appendPath("authorize")
//            .appendQueryParameter("client_id", BuildConfig.GIT_SECRET)
//            .build()
//        Log.e("TAG", "onCreate: $loginUrl", )
//
//        CustomTabsIntent.Builder().build().also {
//            it.launchUrl(this, loginUrl)
//        }
    }

    fun login(context: Context) {
        val loginUrl = Uri.Builder().scheme("https").authority("github.com")
            .appendPath("login")
            .appendPath("oauth")
            .appendPath("authorize")
            .appendQueryParameter("client_id", BuildConfig.GIT_SECRET)
            .build()

        Log.e("TAG", "onCreate: $loginUrl", )

        CustomTabsIntent.Builder().build().also {
            it.launchUrl(context, loginUrl)
        }
    }

    override fun onRestart() {
        super.onRestart()

        val uri: Uri? = intent?.data

        Log.e("TAG", "onResume: start", )

        if (uri != null){
            val code = uri.getQueryParameter("code")
            Log.e("TAG", "onResume code : $code", )
//            if(code != null){
//                showDialog()
//                viewModel.getAccessToken(code)
//                Toast.makeText(this, "Login success!", Toast.LENGTH_SHORT).show()
//            } else if((uri.getQueryParameter("error")) != null){
//                Log.d(TAG, "error: ${uri.getQueryParameter("error")}")
//                Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show()
//            }
        }
    }

//    private fun processLogin() {
//        Log.e("TAG", "processLogin start", )
//        //showDialog()
//        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(
//            "${BuildConfig.oauthLoginURL}?client_id=${BuildConfig.GIT_SECRET}&scope=repo"))
//
//        startActivity(intent)
//    }

}
