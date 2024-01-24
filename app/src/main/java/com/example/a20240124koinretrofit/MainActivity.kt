package com.example.a20240124koinretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a20240124koinretrofit.adapter.FighterAdapter
import com.example.a20240124koinretrofit.databinding.ActivityMainBinding
import com.example.a20240124koinretrofit.model.HomeViewModel
import com.example.a20240124koinretrofit.model.MovieModel
import okhttp3.internal.notify
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: FighterAdapter
    private val mainViewModel: HomeViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//val nullList : List<MovieModel>

        binding.rcv.apply {
            adapter = FighterAdapter()
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL,false)
            setHasFixedSize(true)
        }
        mainViewModel.responseTVShow.observe(this
        ) { lst ->
            adapter.list =lst
            adapter.notify()
        }
    }
}