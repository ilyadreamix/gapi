package io.github.ilyadreamix.gapi.drive

/**
 * **Google Drive API**
 *
 * The Google Drive API allows clients to access resources from Google Drive.
 *
 * **See Also:** [Official documentation](https://developers.google.com/drive/api/reference/rest/v3)
 */
class GApiDrive(accessToken: String) {
    /**
     * @see [GApiDriveFiles]
     */
    val files by lazy { GApiDriveFiles(accessToken) }
}
