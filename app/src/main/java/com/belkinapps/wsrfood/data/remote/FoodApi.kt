package com.belkinapps.wsrfood.data.remote

import com.belkinapps.wsrfood.data.requests.LoginRequest
import com.belkinapps.wsrfood.data.requests.RegisterRequest
import com.belkinapps.wsrfood.data.responses.TokenResponse
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface FoodApi {

    @POST("./auth/login")
    fun sendLoginRequest(@Body loginRequest: LoginRequest): Single<TokenResponse>

    @POST("./auth/register")
    fun sendRegisterRequest(@Body registerRequest: RegisterRequest): Completable
}