package io.github.ilyadreamix.gapi.common.error

class GApiException(response: GApiErrorResponse) : Exception() {
    override val message = response.info.message
}
