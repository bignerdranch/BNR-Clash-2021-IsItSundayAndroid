package com.bignerdranch.isitsunday.data

import retrofit2.http.GET

interface SundayService {

    @GET("https://bnr-clash-sunday.herokuapp.com/v1/isSunday")
    suspend fun getSundayResponse(): SundayResponse
}