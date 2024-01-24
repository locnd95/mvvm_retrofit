package com.example.a20240124koinretrofit.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a20240124koinretrofit.home_repo.HomeRepo
import com.example.a20240124koinretrofit.model.MovieModel
import kotlinx.coroutines.launch


class HomeViewModel(private val repo: HomeRepo) : ViewModel() {
    private var _response = MutableLiveData<List<MovieModel>>()
    val responseTVShow: LiveData<List<MovieModel>>
        get() = _response

    init {
        getListTVShows()
    }

    private fun getListTVShows() =viewModelScope.launch {
        repo.getListMove().let { response ->
            if (response.isSuccessful){
                _response.postValue(response.body())
            }else {
                Log.d("getListTVShows","getListTVShows Error : ${response.code()}")
            }
        }
    }
}