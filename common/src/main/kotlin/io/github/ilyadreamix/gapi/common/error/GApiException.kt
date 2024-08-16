package io.github.ilyadreamix.gapi.common.error

import io.ktor.http.*

class GApiException(val response: GApiErrorResponse) : Exception() {

    override val message = response.info.message

    fun isBadRequest() = response.info.code == HttpStatusCode.BadRequest.value
    fun isUnauthorized() = response.info.code == HttpStatusCode.Unauthorized.value
    fun isForbidden() = response.info.code == HttpStatusCode.Forbidden.value
}
