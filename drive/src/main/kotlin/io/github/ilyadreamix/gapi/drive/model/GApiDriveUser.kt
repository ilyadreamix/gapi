package io.github.ilyadreamix.gapi.drive.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GApiDriveUser(
    @SerialName("displayName") val displayName: String? = null,
    @SerialName("kind") val kind: String? = null,
    @SerialName("me") val me: Boolean? = null,
    @SerialName("permissionId") val permissionId: String? = null,
    @SerialName("emailAddress") val emailAddress: String? = null,
    @SerialName("photoLink") val photoLink: String? = null
)
