package com.maroc.week5.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.maroc.week5.databinding.ActivityMainBinding
import com.maroc.week5.service.RetrofitInstancePostsList
import com.maroc.week5.ui.utils.PostsListAdapter
import retrofit2.HttpException
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var postListApiAdapter: PostsListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        lifecycleScope.launchWhenCreated {
            binding.pbPostListApi.isVisible = true

            val response = try {
                RetrofitInstancePostsList.api.getPosts()
            } catch (e: IOException) {
                Log.d("MainActivity", "You may have no internet connexion")
                binding.pbPostListApi.isVisible = false
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.d("MainActivity", "Unexpected response")
                binding.pbPostListApi.isVisible = false
                return@launchWhenCreated
            }

            if (response.isSuccessful && response.body() != null) {
                postListApiAdapter.posts = response.body()!!
            } else {
                Log.d("MainActivity", "Response is not successful")
                Toast.makeText(this@MainActivity, "Response is not successful", Toast.LENGTH_SHORT)
                    .show()
            }
            binding.pbPostListApi.isVisible = false

        }
    }

    private fun setupRecyclerView() = binding.rvPostListApi.apply {
        postListApiAdapter = PostsListAdapter()
        adapter = postListApiAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)
    }
}