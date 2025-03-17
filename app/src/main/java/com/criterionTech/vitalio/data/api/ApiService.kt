package com.criterionTech.vitalio.data.api

import com.criterionTech.vitalio.data.modal.User
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsers(): List<User>

}