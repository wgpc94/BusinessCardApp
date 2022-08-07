package com.example.businesscard

import android.app.Application
import com.example.businesscard.data.AppDataBase
import com.example.businesscard.data.BusinessCardRepository

class App : Application() {
    private val appDataBase by lazy { AppDataBase.getDataBase(this) }
    val businessCardRepository by lazy { BusinessCardRepository(appDataBase.getBusinessCardDao()) }
}