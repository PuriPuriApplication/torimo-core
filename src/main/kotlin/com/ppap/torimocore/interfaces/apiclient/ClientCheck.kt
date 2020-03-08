package com.ppap.torimocore.interfaces.apiclient

import retrofit2.http.GET
import retrofit2.http.Query


interface ClientCheck {

    @GET("/")
    suspend fun test(@Query("zipcode") zipcode: String): ClientCheckDto

}

data class ClientCheckDto(
        val code: Int,
        val data: Data
)

data class Data(
        val pref: String,
        val address: String,
        val city: String,
        val town: String
//      val fullAddress: String
)