package com.kjy.retrofitproject

import com.google.gson.annotations.SerializedName

// 레트로핏의 3가지 구성요소 중 Model 역할을 할 data class를 설정.
data class Post(
    // @SerializedName 어노테이션 사용시 JSON과의 직렬화 시 사용자의 이름을 지정할 때 사용한다.
    @SerializedName("userId")
    val myUserId : Int,
    val id : Int,
    val title : String,
    val body : String
)
