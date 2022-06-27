package com.maroc.week5.service

import com.maroc.week5.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface PostsListApi {
    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>
}