package com.belkinapps.wsrfood.data.remote

import com.belkinapps.wsrfood.data.requests.LoginRequest
import com.belkinapps.wsrfood.data.requests.RegisterRequest
import com.belkinapps.wsrfood.data.responses.Item
import com.belkinapps.wsrfood.data.responses.TokenResponse
import com.belkinapps.wsrfood.data.responses.VersionResponse
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface FoodApi {

    @POST("./auth/login")
    fun sendLoginRequest(@Body loginRequest: LoginRequest): Single<TokenResponse>

    @POST("./auth/register")
    fun sendRegisterRequest(@Body registerRequest: RegisterRequest): Completable

    @GET("./dishes")
    fun sendDishesRequest(@Query("version") version: String): Single<List<Item>>

    @GET("./dishes/version")
    fun sendVersionRequest(): Single<VersionResponse>
}