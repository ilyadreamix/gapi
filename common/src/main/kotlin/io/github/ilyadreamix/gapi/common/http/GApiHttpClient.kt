package io.github.ilyadreamix.gapi.common.http

import io.github.ilyadreamix.gapi.common.service.GApiServiceType
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class GApiHttpClient(
    serviceType: GApiServiceType,
    accessToken: String,
    retryAttempts: Int? = null,
    logLevel: LogLevel = LogLevel.NONE
) {
    private val mServiceType = serviceType
    private val mAccessToken = accessToken
    private val mRetryAttempts = retryAttempts
    private val mLogLevel = logLevel

    private val mLogger = GApiHttpClientLogger(mServiceType)
    private val mHttpClient = buildHttpClient()

    suspend fun get(url: String, overrideUrl: Boolean = false, block: HttpRequestBuilder.() -> Unit) =
        mHttpClient.get(
            urlString = if (overrideUrl) url else "${mServiceType.url}/$url",
            block = block
        )

    suspend fun post(url: String, overrideUrl: Boolean = false, block: HttpRequestBuilder.() -> Unit) =
        mHttpClient.post(
            urlString = if (overrideUrl) url else "${mServiceType.url}/$url",
            block = block
        )

    suspend fun delete(url: String, overrideUrl: Boolean = false, block: HttpRequestBuilder.() -> Unit) =
        mHttpClient.delete(
            urlString = if (overrideUrl) url else "${mServiceType.url}/$url",
            block = block
        )

    suspend fun put(url: String, overrideUrl: Boolean = false, block: HttpRequestBuilder.() -> Unit) =
        mHttpClient.put(
            urlString = if (overrideUrl) url else "${mServiceType.url}/$url",
            block = block
        )

    suspend fun head(url: String, overrideUrl: Boolean = false, block: HttpRequestBuilder.() -> Unit) =
        mHttpClient.head(
            urlString = if (overrideUrl) url else "${mServiceType.url}/$url",
            block = block
        )

    suspend fun options(url: String, overrideUrl: Boolean = false, block: HttpRequestBuilder.() -> Unit) =
        mHttpClient.options(
            urlString = if (overrideUrl) url else "${mServiceType.url}/$url",
            block = block
        )

    suspend fun patch(url: String, overrideUrl: Boolean = false, block: HttpRequestBuilder.() -> Unit) =
        mHttpClient.patch(
            urlString = if (overrideUrl) url else "${mServiceType.url}/$url",
            block = block
        )

    suspend fun submitFormWithBinaryData(
        url: String,
        overrideUrl: Boolean = false,
        formData: List<PartData>,
        block: HttpRequestBuilder.() -> Unit
    ) = mHttpClient.submitFormWithBinaryData(
        url = if (overrideUrl) url else "${mServiceType.url}/$url",
        formData = formData,
        block = block
    )

    private fun buildHttpClient(): HttpClient {
        val httpClient = HttpClient(CIO) {
            install(Logging) {
                logger = mLogger
                level = mLogLevel
            }

            install(ContentNegotiation) {
                json(
                    json = Json {
                        ignoreUnknownKeys = true
                    }
                )
            }

            mRetryAttempts?.let { retryAttempts ->
                install(HttpRequestRetry) {
                    maxRetries = retryAttempts
                    retryIf { _, response -> !response.status.isSuccess() }
                }
            }
        }

        httpClient
            .plugin(HttpSend)
            .intercept { call ->
                call.bearerAuth(mAccessToken)
                execute(call)
            }

        return httpClient
    }
}
