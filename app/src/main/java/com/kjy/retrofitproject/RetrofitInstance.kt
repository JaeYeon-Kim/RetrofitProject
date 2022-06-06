package com.kjy.retrofitproject

import com.kjy.retrofitproject.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// 레트로핏의 3가지 구성요소 중 Retrofit.Builder 클래스 역할로 BASE_URL 과 Converter를 설정해준다.
// by lazy로 늦은 초기화 해줌으로써 api 변수가 사용될 때 초기화되고, 그 안에서 retrofit 변수를 사용하기 때문에 초기화 된다.
object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}