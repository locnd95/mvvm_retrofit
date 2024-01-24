package com.example.a20240124koinretrofit.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a20240124koinretrofit.home_repo.HomeRepo
import kotlinx.coroutines.launch

class HomeViewModel(private val homeRepo: HomeRepo) : ViewModel() {

    private var _response = MutableLiveData<List<MovieModel>>()

    val responseTVShow: LiveData<List<MovieModel>>
        get() = _response

    init {
        getListTVShow()
    }


    private fun getListTVShow() = viewModelScope.launch {
        homeRepo.getListMove().let { res ->
            if (res.isSuccessful) {
                _response.postValue(res.body())
            } else {
                Log.d("getListTVShows","getListTVShows Error : ${res.code()}")
            }
        }
    }
}