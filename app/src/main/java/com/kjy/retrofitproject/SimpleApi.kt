package com.kjy.retrofitproject

import retrofit2.http.GET

// 레트로핏의 3가지 구성요소 중 Interface 역할을 할 인터페이스를 생성.
// suspend 함수를 호출함으로서 해당 함수는 비동기 환경에서 구동이 가능하다를 뜻함.
interface SimpleApi {
    @GET("posts/1")
    suspend fun getPost() : Post
}