package io.github.ilyadreamix.gapi.drive.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GApiDrivePermission(
    @SerialName("id") val id: String? = null,
    @SerialName("displayName") val displayName: String? = null,
    @SerialName("type") val type: String? = null,
    @SerialName("kind") val kind: String? = null,
    @SerialName("permissionDetails") val permissionDetails: List<PermissionDetail>? = null,
    @SerialName("photoLink") val photoLink: String? = null,
    @SerialName("emailAddress") val emailAddress: String? = null,
    @SerialName("role") val role: String? = null,
    @SerialName("allowFileDiscovery") val allowFileDiscovery: Boolean? = null,
    @SerialName("domain") val domain: String? = null,
    @SerialName("expirationTime") val expirationTime: String? = null,
    @SerialName("teamDrivePermissionDetails") val teamDrivePermissionDetails: List<TeamDrivePermissionDetail>? = null,
    @SerialName("deleted") val deleted: Boolean? = null,
    @SerialName("view") val view: String? = null,
    @SerialName("pendingOwner") val pendingOwner: Boolean? = null
) {
    @Serializable
    data class PermissionDetail(
        @SerialName("permissionType") val permissionType: String? = null,
        @SerialName("inheritedFrom") val inheritedFrom: String? = null,
        @SerialName("role") val role: String? = null,
        @SerialName("inherited") val inherited: Boolean? = null
    )

    @Serializable
    data class TeamDrivePermissionDetail(
        @SerialName("teamDrivePermissionType") val teamDrivePermissionType: String? = null,
        @SerialName("inheritedFrom") val inheritedFrom: String? = null,
        @SerialName("role") val role: String? = null,
        @SerialName("inherited") val inherited: Boolean? = null
    )
}
