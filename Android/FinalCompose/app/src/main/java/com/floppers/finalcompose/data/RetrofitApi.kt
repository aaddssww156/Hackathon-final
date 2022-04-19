package com.floppers.finalcompose.data

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetrofitApi {

    @Headers("Content-Type: application/json")
    @POST("/dj-rest-auth/registration/")
    suspend fun postNewUser(@Body userData: NewUser)

    @GET("/rooms/")
    suspend fun getRooms(): Response<List<RoomsData>>
}