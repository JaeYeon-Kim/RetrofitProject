package com.kjy.retrofitproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


// ViewModelFactory : ViewModel을 통해 전달되는 인자가 있을 때 사용.
// 뷰모델에서 파라미터로 Repository를 받아야 하므로 Factory를 생성해준다.
class MainViewModelFactory(
    private val repository: Repository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}
