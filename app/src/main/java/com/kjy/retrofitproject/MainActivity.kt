package com.kjy.retrofitproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kjy.retrofitproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // repository와 뷰모델을 연결해주고, getPost()를 호출해 통신을 요청
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        // 숫자 입력 후 버튼 클릭시 통신한 값이 출력되도록 한다. 만약 통신 실패시 에러코드를 출력
        // 람다식으로 표현
        viewModel.myResponse2.observe(this, Observer {
            //
            if(it.isSuccessful) {
                binding.TextView.text = it.body().toString()
            } else {
                // 에러시 HTTP 상태 코드 출력
                binding.TextView.text = it.code().toString()
            }

        })

        binding.showButton.setOnClickListener {
            val myNumber = binding.editTextNumber.text.toString()
            viewModel.getPost2(Integer.parseInt(myNumber))
        }

    }
}