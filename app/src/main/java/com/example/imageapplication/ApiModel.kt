package com.example.imageapplication

import com.google.gson.annotations.SerializedName

class ApiModel(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("url") val url: String
)