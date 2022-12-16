package com.example.pureumgittest

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pureumgittest.databinding.ActivityMainBinding
import com.example.pureumgittest.databinding.ActivityRecyclerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val myViewModel: MyViewModel by viewModels()
    private val adapter = Adapter()

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        //binding.repoRecyclerview.isVisible = false

        Log.e("TAG", "onCreate: start", )

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            processLogin()
        }
        myViewModel.accessToken.observe(this) { accessToken ->
            binding.textView2.text = accessToken.accessToken
        }

        binding.userbutton.setOnClickListener{
            myViewModel.viewModelGetUserData()
        }

        binding.repoButton.setOnClickListener{
            //binding.repoRecyclerview.isVisible = true
            myViewModel.viewModelGetRepo()
        }

        myViewModel.userData.observe(this) { userdata ->
            Log.e("TAG", "onCreate: $userdata", )
            binding.userdata.text = userdata.toString()
        }

        myViewModel.repo.observe(this) { repo ->
            binding.repo.text = repo.toString()
        }


        myViewModel.repo.observe(this){
            //Log.e("TAG", "onCreate: $it ", )
            binding.repoRecyclerview.layoutManager = LinearLayoutManager(this)
            binding.repoRecyclerview.adapter = adapter
            adapter.dataList = it
            Log.e("TAG", "onCreate: ${adapter.dataList}")
        }
    }

    private fun processLogin() {
        Log.e("TAG", "proce2ssLogin start", )
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
            binding.textView.text = "$code"
            if(code != null){
                Toast.makeText(this, "Login success!", Toast.LENGTH_SHORT).show()
                myViewModel.viewModelGetAccessToken(code)
                //val intent = Intent(this, RecyclerActivity::class.java)
                //intent.putExtra("access", myViewModel._accessToken.value.toString())
                //startActivity(intent)
            } else if((uri.getQueryParameter("error")) != null){
                Log.d("TAG", "error: ${uri.getQueryParameter("error")}")
                Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
