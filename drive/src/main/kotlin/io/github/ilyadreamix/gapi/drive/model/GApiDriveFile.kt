package io.github.ilyadreamix.gapi.drive.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GApiDriveFile(
    @SerialName("id") val id: String? = null,
    @SerialName("name") val name: String? = null,
    @SerialName("mimeType") val mimeType: String? = null,
    @SerialName("createdTime") val createdTime: String? = null,
    @SerialName("modifiedTime") val modifiedTime: String? = null,
    @SerialName("webContentLink") val webContentLink: String? = null,
    @SerialName("thumbnailLink") val thumbnailLink: String? = null
)
