package io.github.ilyadreamix.gapi.drive.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GApiDriveFileList(
    @SerialName("nextPageToken") val nextPageToken: String? = null,
    @SerialName("kind") val kind: String? = null,
    @SerialName("incompleteSearch") val incompleteSearch: Boolean? = null,
    @SerialName("files") val files: List<GApiDriveFile>? = null
)
