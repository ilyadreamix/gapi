package io.github.ilyadreamix.gapi

import io.github.ilyadreamix.gapi.drive.GApiDrive

/**
 * **GApi**
 *
 * GApi is a Kotlin library that makes it easy to access Google services APIs.
 *
 * **Google Drive API:** [GApiDrive]
 */
class GApi(accessToken: String) {
    /**
     * @see [GApiDrive]
     */
    val drive by lazy { GApiDrive(accessToken) }
}
