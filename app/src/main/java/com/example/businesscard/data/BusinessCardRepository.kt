package com.example.businesscard.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BusinessCardRepository(private val businessCardDao: BusinessCardDao) {

    fun insert(businessCardEntity: BusinessCardEntity){
        runBlocking {
            launch (Dispatchers.IO){
                businessCardDao.insert(businessCardEntity)
            }
        }
    }

    fun getAll() :LiveData<List<BusinessCardEntity>>{
        return businessCardDao.getAll()
    }
}