package io.github.ilyadreamix.gapi.drive.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GApiDriveLabel(
    @SerialName("id") val id: String? = null,
    @SerialName("revisionId") val revisionId: String? = null,
    @SerialName("kind") val kind: String? = null,
    @SerialName("fields") val fields: Map<String, GApiDriveField>? = null
)
