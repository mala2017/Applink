package com.seam.demo.seam

import retrofit2.http.GET
import retrofit2.http.Header

interface SeamApiService {

    @GET("workspaces/get")
    suspend fun getWorkspaces(@Header("Authorization") authKey: String ): WorkspaceResponse

}