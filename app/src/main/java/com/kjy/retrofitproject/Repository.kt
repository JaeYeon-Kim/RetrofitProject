package com.kjy.retrofitproject

import retrofit2.Response


// MVVM 패턴을 위한 데이터 통신을 하는 Repository를 생성.
// 여기서 통신한 값을 뷰모델에서 사용.
class Repository {
    suspend fun getPost() : Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    // 실질적으로 메소드를 사용하는 곳
    suspend fun getPost2(number : Int) : Response<Post> {
        return RetrofitInstance.api.getPost2(number)
    }
}