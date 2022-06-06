package com.kjy.retrofitproject


// MVVM 패턴을 위한 데이터 통신을 하는 Repository를 생성.
// 여기서 통신한 값을 뷰모델에서 사용.
class Repository {
    suspend fun getPost() : Post {
        return RetrofitInstance.api.getPost()
    }
}