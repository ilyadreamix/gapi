package io.github.ilyadreamix.gapi.drive

class GApiDrive(accessToken: String) {
    val files by lazy { GApiDriveFiles(accessToken) }
}
