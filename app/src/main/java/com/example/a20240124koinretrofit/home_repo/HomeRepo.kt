package com.example.a20240124koinretrofit.home_repo

import com.example.a20240124koinretrofit.api_service.ApiService

class HomeRepo (private val api: ApiService) {
    suspend fun getListMove()= api.getTVShows()
}