package io.github.ilyadreamix.gapi.common.service

import io.github.ilyadreamix.gapi.common.http.GApiHttpClient
import io.github.ilyadreamix.gapi.common.etc.logger

abstract class GApiService(type: GApiServiceType, accessToken: String) {
    protected val httpClient = GApiHttpClient(
        serviceType = type,
        accessToken = accessToken
    )

    protected val logger = type.logger
}
