package com.example.businesscard.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.businesscard.App
import com.example.businesscard.data.BusinessCardEntity
import com.example.businesscard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), BusinessCardAdapter.OnUpdatedCard {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel : MainViewModel by viewModels {
        MainViewModelFactory((application as App).businessCardRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getAllBusinessCards()
        setListeners()
    }

    private fun getAllBusinessCards() {
        mainViewModel.getAll().observe(this) {
            binding.rvCards.adapter = BusinessCardAdapter(it, this)
        }
    }

    private fun setListeners() {
        binding.fabAdd.setOnClickListener {
            val intent = Intent(this, AddBusinessCardActivity::class.java)
            startActivity(intent)
        }
    }

    override fun saveCard(businessCardEntity: BusinessCardEntity) {
        mainViewModel.insert(businessCardEntity)
    }
}