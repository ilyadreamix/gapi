package io.github.ilyadreamix.gapi.drive.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GApiDriveContentRestriction(
    @SerialName("readOnly") val readOnly: Boolean? = null,
    @SerialName("reason") val reason: String? = null,
    @SerialName("type") val type: String? = null,
    @SerialName("restrictingUser") val restrictingUser: GApiDriveUser? = null,
    @SerialName("restrictionTime") val restrictionTime: String? = null,
    @SerialName("ownerRestricted") val ownerRestricted: Boolean? = null,
    @SerialName("systemRestricted") val systemRestricted: Boolean? = null
)
