package com.kjy.retrofitproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

// ViewModel 생성
class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse : MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponse2 : MutableLiveData<Response<Post>> = MutableLiveData()

    fun getPost() {
        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }
    }

    // 결과값을 받을 MyResponse2 라이브 데이터를 생성해주고, 아까 저장소에서 정의한 메소드를 사용하여 할당.
    fun getPost2(number : Int) {
        viewModelScope.launch {
            val reponse = repository.getPost2(number)
            myResponse2.value = reponse
        }
    }
}