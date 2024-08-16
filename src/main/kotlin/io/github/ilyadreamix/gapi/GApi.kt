package io.github.ilyadreamix.gapi

import io.github.ilyadreamix.gapi.drive.GApiDrive

/**
 * **GApi**
 *
 * GApi is a Kotlin library that allows you to access Google services API.
 *
 * **Google Drive API:** [GApiDrive]
 */
class GApi(accessToken: String) {
    /**
     * @see [GApiDrive]
     */
    val drive by lazy { GApiDrive(accessToken) }
}
