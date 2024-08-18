package io.github.ilyadreamix.gapi.core.http

import io.github.ilyadreamix.gapi.core.etc.logger
import io.github.ilyadreamix.gapi.core.service.GApiServiceType
import io.ktor.client.plugins.logging.*

internal class GApiHttpClientLogger(private val serviceType: GApiServiceType) : Logger {
    override fun log(message: String) {
        serviceType.logger.debug { "[HttpClient] $message" }
    }
}
