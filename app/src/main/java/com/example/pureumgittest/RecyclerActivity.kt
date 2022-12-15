//package com.example.pureumgittest
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import androidx.activity.viewModels
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.pureumgittest.databinding.ActivityRecyclerBinding
//import dagger.hilt.android.AndroidEntryPoint
//
//@AndroidEntryPoint
//class RecyclerActivity : AppCompatActivity() {
//
//    private val myViewModel: MyViewModel by viewModels()
//    private val adapter = Adapter()
//    private var access = ""
//
//    private val binding : ActivityRecyclerBinding by lazy {
//        ActivityRecyclerBinding.inflate(layoutInflater)
//    }
//
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(binding.root)
//
//        Log.e("TAG", "메인에서 받아온 id : $access")
//
//        if (intent.hasExtra("access"))
//        {
//            access = intent.getStringExtra("access").toString()
//
//            Log.e("TAG", "메인에서 받아온 id : $access")
//        }
//
//        binding.button5.setOnClickListener{
//            myViewModel.viewModelGetUserData()
//        }
//
//        binding.button4.setOnClickListener{
//            myViewModel.viewModelGetRepo()
//        }
//
//        myViewModel.userData.observe(this) { userdata ->
//            Log.e("TAG", "onCreate: $userdata", )
//            binding.userdata2.text = userdata.toString()
//        }
//
//        myViewModel.repo.observe(this) { repo ->
//            Log.e("TAG", "onCreate: $repo", )
//            binding.repo2.text = repo.toString()
//        }
//
//        binding.repoRecyclerview.layoutManager = LinearLayoutManager(this)
//        binding.repoRecyclerview.adapter = adapter
//        myViewModel.repo.observe(this){
//            adapter.dataList.add(it)
//        }
//
//    }
//}