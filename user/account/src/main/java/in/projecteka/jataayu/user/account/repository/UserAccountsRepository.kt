package `in`.projecteka.jataayu.user.account.repository

import `in`.projecteka.jataayu.core.model.CreateAccountRequest
import `in`.projecteka.jataayu.core.model.CreateAccountResponse
import `in`.projecteka.jataayu.core.model.LinkedAccountsResponse
import `in`.projecteka.jataayu.core.model.MyProfile
import `in`.projecteka.jataayu.user.account.remote.UserAccountApis
import retrofit2.Call

interface UserAccountsRepository {
    fun getUserAccounts() : Call<LinkedAccountsResponse>
    fun createAccount(createAccountRequest: CreateAccountRequest): Call<CreateAccountResponse>
    fun getMyProfile(): Call<MyProfile>
    fun logout(refreshToken: String): Call<Void>
}

class UserAccountsRepositoryImpl(private val userAccountApis: UserAccountApis): UserAccountsRepository {
    override fun getUserAccounts(): Call<LinkedAccountsResponse> {
        return userAccountApis.getUserAccounts()
    }

    override fun createAccount(createAccountRequest: CreateAccountRequest): Call<CreateAccountResponse> {
        return userAccountApis.createAccount(createAccountRequest)
    }

    override fun getMyProfile(): Call<MyProfile> {
        return userAccountApis.getMyProfile()
    }

    override fun logout(refreshToken: String): Call<Void> {
        return userAccountApis.logout(mapOf("refreshToken" to refreshToken))
    }
}
