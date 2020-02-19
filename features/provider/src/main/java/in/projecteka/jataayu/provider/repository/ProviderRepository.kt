package `in`.projecteka.jataayu.provider.repository

import `in`.projecteka.jataayu.core.model.ProviderInfo
import `in`.projecteka.jataayu.core.model.Request
import `in`.projecteka.jataayu.provider.model.LinkAccountsResponse
import `in`.projecteka.jataayu.provider.model.Otp
import `in`.projecteka.jataayu.provider.model.PatientDiscoveryResponse
import `in`.projecteka.jataayu.provider.model.SuccessfulLinkingResponse
import `in`.projecteka.jataayu.provider.remote.ProviderApis
import retrofit2.Call

interface ProviderRepository {
    fun getProviders(name: String): Call<List<ProviderInfo>>
    fun getPatientAccounts(request: Request): Call<PatientDiscoveryResponse>
    fun linkPatientAccounts(patientDiscoveryResponse: PatientDiscoveryResponse): Call<LinkAccountsResponse>
    fun verifyOtp(referenceNumber: String, otp: Otp): Call<SuccessfulLinkingResponse>
}

class ProviderRepositoryImpl(private val providerApi: ProviderApis) : ProviderRepository {
    override fun getProviders(name: String): Call<List<ProviderInfo>> {
        return providerApi.getProviders(name)
    }

    override fun getPatientAccounts(request: Request): Call<PatientDiscoveryResponse> {
        return providerApi.getPatientAccounts(request)
    }

    override fun linkPatientAccounts(patientDiscoveryResponse: PatientDiscoveryResponse): Call<LinkAccountsResponse> {
        return providerApi.linkPatientAccounts(patientDiscoveryResponse)
    }

    override fun verifyOtp(referenceNumber: String, otp: Otp): Call<SuccessfulLinkingResponse> {
        return providerApi.verifyOtp(referenceNumber, otp)
    }
}