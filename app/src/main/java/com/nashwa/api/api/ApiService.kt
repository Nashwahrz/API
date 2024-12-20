package com.nashwa.api.api

import com.nashwa.api.model.BeritaResponse
import com.nashwa.api.model.LoginRequest
import com.nashwa.api.model.LoginResponse
import com.nashwa.api.model.RegisterRequest
import com.nashwa.api.model.RegisterResponse

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {


    @FormUrlEncoded
    @POST("API_BASIC/register.php")
    fun register(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("fullname") fullname: String,
        @Field("email") email: String,

        ): Call<RegisterResponse>

    @FormUrlEncoded
    @POST("API_BASIC/login.php")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String,


        ): Call<LoginResponse>

        @GET("API_BASIC/get_berita.php")
        fun getListBerita(@Query("judul") judul: String): Call<BeritaResponse>

//    @POST("API_BASIC/register.php")
//    fun register(@Body request: RegisterRequest): Call<RegisterResponse>
//
//    @POST("API_BASIC/login.php")
//    fun login(@Body request: LoginRequest): Call<LoginResponse>
}