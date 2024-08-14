package com.example.retrofit_1

import PostAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var postAdapter: PostAdapter
    private lateinit var  recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchPosts()
    }

    private fun fetchPosts() {
        ApiService.RetrofitInstance.api.getPosts().enqueue(object : Callback<PostResponse>{
            override fun onResponse(call: Call<PostResponse>, response: Response<PostResponse>) {
                if(response.isSuccessful){
                    val posts = response.body()?.posts ?: emptyList()
                    postAdapter = PostAdapter(posts)
                    recyclerView.adapter = postAdapter
                }
            }

            override fun onFailure(call: Call<PostResponse>, t: Throwable) {

            }

        })
    }
}