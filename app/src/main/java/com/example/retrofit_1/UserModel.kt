package com.example.retrofit_1

import com.google.gson.annotations.SerializedName

data class UserModel(
    val title: String,
    val reactions:Reactions,
    val views: Int
)
data class PostResponse(
    val posts: List<UserModel>
)
data class  Reactions(
    val likes: Int,
    val dislikes: Int
)