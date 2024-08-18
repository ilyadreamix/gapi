package io.github.ilyadreamix.gapi.core.service

import io.github.ilyadreamix.gapi.core.etc.logger
import io.github.ilyadreamix.gapi.core.http.GApiHttpClient

abstract class GApiService(type: GApiServiceType, accessToken: String) {
    protected val httpClient = GApiHttpClient(
        serviceType = type,
        accessToken = accessToken
    )

    protected val logger = type.logger
}
