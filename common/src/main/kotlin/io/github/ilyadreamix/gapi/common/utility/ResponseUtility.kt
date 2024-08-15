package io.github.ilyadreamix.gapi.common.utility

import io.github.ilyadreamix.gapi.common.error.GApiErrorResponse
import io.github.ilyadreamix.gapi.common.error.GApiException
import io.ktor.client.call.*
import io.ktor.client.statement.*
import io.ktor.http.*

suspend inline fun <reified T> HttpResponse.getOrThrow(): T {
    if (!this.status.isSuccess()) {
        val errorResponse = this.body<GApiErrorResponse>()
        throw GApiException(errorResponse)
    }

    return this.body<T>()
}
