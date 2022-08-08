package com.example.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.businesscard.App
import com.example.businesscard.data.BusinessCardEntity
import com.example.businesscard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBusinessCardBinding
    private val mainViewModel : MainViewModel by viewModels {
        MainViewModelFactory((application as App).businessCardRepository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBusinessCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListeners()
    }

    private fun setListeners() {
        binding.ivClose.setOnClickListener {
            finish()
        }
        binding.btnConfirm.setOnClickListener {
            val name = binding.ilName.editText?.text.toString()
            val phone = binding.ilPhone.editText?.text.toString()
            val email = binding.ilEmail.editText?.text.toString()
            val company = binding.ilCompanyName.editText?.text.toString()
            val color = binding.ilColor.editText?.text.toString()

            mainViewModel.insert(BusinessCardEntity(
                0,
                name,
                company,
                phone,
                email,
                color
            ))
            finish()
        }
    }
}