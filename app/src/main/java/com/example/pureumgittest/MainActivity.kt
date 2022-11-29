package com.example.pureumgittest

import android.accounts.AccountManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import com.example.pureumgittest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.e("TAG", "onCreate: start", )

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            processLogin()
        }
    }

    private fun processLogin() {
        Log.e("TAG", "processLogin start", )
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(
            "${BuildConfig.oauthLoginURL}?client_id=${BuildConfig.GIT_SECRET}"))
        Log.e("TAG", "processLogin: ${intent.data}")
        startActivity(intent)
    }

    override fun onResume() {
        Log.e("TAG", "onResume: start", )
        super.onResume()
        val uri: Uri? = intent?.data
        Log.e("TAG", "uri : $uri", )
        if (uri != null){
            val code = uri.getQueryParameter("code")
            binding.textView.text = code
            Log.e("TAG", "onResume code : $code", )
            if(code != null){
//                showDialog()
//                viewModel.getAccessToken(code)
                Toast.makeText(this, "Login success!", Toast.LENGTH_SHORT).show()
//            } else if((uri.getQueryParameter("error")) != null){
//                Log.d(TAG, "error: ${uri.getQueryParameter("error")}")
//                Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show()
            }
        }
    }



}
