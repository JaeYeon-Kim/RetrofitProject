package com.kjy.retrofitproject

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

// 레트로핏의 3가지 구성요소 중 Interface 역할을 할 인터페이스를 생성.
// suspend 함수를 호출함으로서 해당 함수는 비동기 환경에서 구동이 가능하다를 뜻함.
// 가능한 HTTP 동작들을 정의해놓은 인터페이스
interface SimpleApi {
    @GET("posts/1")
    suspend fun getPost() : Response<Post>

    // 인터페이스에서 숫자를 입력받아 그 값에 해당하는 결과를 출력하는 함수 getPost2()를 작성.
    @GET("posts/{postNumber}")
    suspend fun getPost2 (
        // @Path: 동적인 URI를 가능하게 해주는 Annotation
        @Path("postNumber") number : Int
    ): Response<Post>
}