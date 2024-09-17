package com.seam.demo.seam

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SeamRepository {
    private val api: SeamApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://connect.getseam.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(SeamApiService::class.java)
    }

    // Replace with your actual token value
    private val authToken = "seam_testwZ5d_2rCGb2jvCj97cRXthPYKHEFH"

    suspend fun getWorkspaces(): WorkspaceResponse {
        return RetrofitClient.service.getWorkspaces("Bearer $authToken") // Pass the token here
    }
}