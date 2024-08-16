package io.github.ilyadreamix.gapi.common.utility

import io.github.ilyadreamix.gapi.common.error.GApiErrorResponse
import io.github.ilyadreamix.gapi.common.error.GApiException
import io.ktor.client.call.*
import io.ktor.client.statement.*
import io.ktor.http.*

suspend fun HttpResponse.checkIsSuccess() {
    if (!this.status.isSuccess()) {
        val errorResponse = this.body<GApiErrorResponse>()
        throw GApiException(errorResponse)
    }
}

suspend inline fun <reified T> HttpResponse.getOrThrow(): T {
    this.checkIsSuccess()
    return this.body<T>()
}

suspend fun HttpResponse.getBytesOrThrow(): ByteArray {
    this.checkIsSuccess()
    return this.readBytes()
}
