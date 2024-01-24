package com.example.a20240124koinretrofit.helper

import android.app.Application
import com.example.a20240124koinretrofit.di.apiModule
import com.example.a20240124koinretrofit.di.repoModule
import com.example.a20240124koinretrofit.di.viewModelModule
import org.koin.core.context.startKoin


class MyApplication :Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(repoModule, apiModule, viewModelModule))
        }
    }
}