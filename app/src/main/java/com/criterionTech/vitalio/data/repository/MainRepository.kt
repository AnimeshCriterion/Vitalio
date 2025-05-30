package com.criterionTech.vitalio.data.repository

import com.criterionTech.vitalio.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getUsers() = apiHelper.getUsers()
}