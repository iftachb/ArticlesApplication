package com.example.articlesapplication

import com.google.gson.annotations.SerializedName

class Data {
    @SerializedName("data")
    val results: List<Results>? = null
}
class Results {
    @SerializedName("metaData")
    val metaData: Time? = null

    @SerializedName("id")
    val id: String? = null

    @SerializedName("title")
    val title: String? = null

    @SerializedName("imageUrl")
    val imageUrl: String? = null

    @SerializedName("isSaved")
    val isSaved: Boolean = false

    @SerializedName("isLiked")
    val isLiked:Boolean = false

    @SerializedName("likesCount")
    val likesCount:Int = 0

    @SerializedName("category")
    val category: String? = null

    @SerializedName("author")
    val author: Author? = null
}


class Time {
    @SerializedName("creationTime")
    val creationTime: String? = null

    @SerializedName("updateTime")
    val updateTime: String? = null
}

class Author {
    @SerializedName("id")
    val id: String? = null

    @SerializedName("authorName")
    val authorName: String? = null

    @SerializedName("authorAvatar")
    val authorAvatar: AuthorAvatar? = null
}

class AuthorAvatar {
    @SerializedName("imageUrl")
    val imageUrl: String? = null

}