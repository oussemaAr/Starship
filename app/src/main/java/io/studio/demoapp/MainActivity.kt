package io.studio.demoapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import io.studio.demoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val shipadapter = StarshipAdapter()

        binding.starshipsList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = shipadapter
        }

        viewModel.viewState.observe(this) { starships ->
            shipadapter.submitList(starships)
            binding.loading.isVisible = false
            binding.starshipsList.isVisible = true
        }

        binding.search.setOnClickListener {
            binding.loading.isVisible = true
            binding.starshipsList.isVisible = false
            viewModel.loadStartShips(binding.maxPassengers.text.toString().toIntOrZero())
        }
    }
}

