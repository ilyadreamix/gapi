package io.github.ilyadreamix.gapi.drive.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GApiDriveField(
    @SerialName("kind") val kind: String? = null,
    @SerialName("id") val id: String? = null,
    @SerialName("valueType") val valueType: String? = null,
    @SerialName("dateString") val dateString: List<String>? = null,
    @SerialName("integer") val integer: List<String>? = null,
    @SerialName("selection") val selection: List<String>? = null,
    @SerialName("text") val text: List<String>? = null,
    @SerialName("user") val user: List<GApiDriveUser>? = null
)
