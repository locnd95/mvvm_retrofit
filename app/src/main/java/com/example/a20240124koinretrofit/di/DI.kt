package com.example.a20240124koinretrofit.di

import com.example.a20240124koinretrofit.api_service.ApiService
import com.example.a20240124koinretrofit.helper.Constants
import com.example.a20240124koinretrofit.home_repo.HomeRepo
import com.example.a20240124koinretrofit.model.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

val repoModule = module {
    single {
        HomeRepo(get())
    }
}
val apiModule = module {
    single {
        provideBaseUrl()
    }
    single {
        provideRetrofitInstansce(get())
    }
}
val viewModelModule = module {
    viewModel {
        HomeViewModel(get())
    }
}


fun provideBaseUrl() = Constants.BASE_URL

fun provideRetrofitInstansce(BASE_URL: String): ApiService = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(ApiService::class.java)
