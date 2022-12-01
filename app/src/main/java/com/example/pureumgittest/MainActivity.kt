package com.example.pureumgittest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.example.pureumgittest.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val myViewModel: MyViewModel by viewModels()

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

        myViewModel.accessToken.observe(this) { accessToken ->
            binding.textView2.text = "[accessToken]\n ${accessToken.accessToken}"
        }
    }

    private fun processLogin() {
        Log.e("TAG", "processLogin start", )
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(
            "${BuildConfig.oauthLoginURL}?client_id=${BuildConfig.GIT_ID}"))
        Log.e("TAG", "processLogin: ${intent.data}")
        startActivity(intent)
    }

    override fun onResume() {
        Log.e("TAG", "onResume: start", )
        super.onResume()
        val uri: Uri? = intent?.data
        if (uri != null){
            val code = uri.getQueryParameter("code")
            binding.textView.text = "[github code]\n ${code}"
            if(code != null){
                Toast.makeText(this, "Login success!", Toast.LENGTH_SHORT).show()
                myViewModel.viewModeGetAccessToken(code)
            } else if((uri.getQueryParameter("error")) != null){
                Log.d("TAG", "error: ${uri.getQueryParameter("error")}")
                Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show()
            }
        }
    }



}
