package com.example.a20240124koinretrofit.api_service


import com.example.a20240124koinretrofit.helper.Constants
import com.example.a20240124koinretrofit.model.MovieModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun getTVShows(): Response<List<MovieModel>>
}