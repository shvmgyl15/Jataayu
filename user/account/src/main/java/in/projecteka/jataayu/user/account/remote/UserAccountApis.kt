package `in`.projecteka.jataayu.user.account.remote

import `in`.projecteka.jataayu.core.model.CreateAccountRequest
import `in`.projecteka.jataayu.core.model.CreateAccountResponse
import `in`.projecteka.jataayu.core.model.LinkedAccountsResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

interface UserAccountApis {
    @GET("patients/links")
    fun getUserAccounts(): Call<LinkedAccountsResponse>

    @GET("create_account")
    fun createAccount(@Body createAccountRequest: CreateAccountRequest): Call<CreateAccountResponse>
}
