package io.github.ilyadreamix.gapi.common.error

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GApiErrorResponse(@SerialName("error") val info: ErrorInfo) {
    @Serializable
    data class ErrorInfo(
        @SerialName("code") val code: Int,
        @SerialName("message") val message: String,
        @SerialName("errors") val errors: List<Error>
    ) {
        @Serializable
        data class Error(
            @SerialName("domain") val domain: String,
            @SerialName("reason") val reason: String,
            @SerialName("message") val message: String,
            @SerialName("location") val location: String? = null,
            @SerialName("locationType") val locationType: String? = null
        )
    }
}
