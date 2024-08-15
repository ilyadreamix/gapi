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
    @SerialName("thumbnailLink") val thumbnailLink: String? = null,
    @SerialName("driveId") val driveId: String? = null,
    @SerialName("fileExtension") val fileExtension: String? = null,
    @SerialName("copyRequiresWriterPermission") val copyRequiresWriterPermission: Boolean? = null,
    @SerialName("md5Checksum") val md5Checksum: String? = null,
    @SerialName("writersCanShare") val writersCanShare: Boolean? = null,
    @SerialName("viewedByMe") val viewedByMe: Boolean? = null,
    @SerialName("exportLinks") val exportLinks: Map<String, String>? = null,
    @SerialName("parents") val parents: List<String>? = null,
    @SerialName("shared") val shared: Boolean? = null,
    @SerialName("headRevisionId") val headRevisionId: String? = null,
    @SerialName("webViewLink") val webViewLink: String? = null,
    @SerialName("size") val size: String? = null,
    @SerialName("viewersCanCopyContent") val viewersCanCopyContent: Boolean? = null,
    @SerialName("hasThumbnail") val hasThumbnail: Boolean? = null,
    @SerialName("spaces") val spaces: List<String>? = null,
    @SerialName("folderColorRgb") val folderColorRgb: String? = null,
    @SerialName("description") val description: String? = null,
    @SerialName("starred") val starred: Boolean? = null,
    @SerialName("trashed") val trashed: Boolean? = null,
    @SerialName("explicitlyTrashed") val explicitlyTrashed: Boolean? = null,
    @SerialName("modifiedByMeTime") val modifiedByMeTime: String? = null,
    @SerialName("viewedByMeTime") val viewedByMeTime: String? = null,
    @SerialName("sharedWithMeTime") val sharedWithMeTime: String? = null,
    @SerialName("quotaBytesUsed") val quotaBytesUsed: String? = null,
    @SerialName("version") val version: String? = null,
    @SerialName("originalFilename") val originalFilename: String? = null,
    @SerialName("ownedByMe") val ownedByMe: Boolean? = null,
    @SerialName("fullFileExtension") val fullFileExtension: String? = null,
    @SerialName("properties") val properties: Map<String, String>? = null,
    @SerialName("appProperties") val appProperties: Map<String, String>? = null,
    @SerialName("isAppAuthorized") val isAppAuthorized: Boolean? = null,
    @SerialName("teamDriveId") val teamDriveId: String? = null,
    @SerialName("hasAugmentedPermissions") val hasAugmentedPermissions: Boolean? = null,
    @SerialName("thumbnailVersion") val thumbnailVersion: String? = null,
    @SerialName("trashedTime") val trashedTime: String? = null,
    @SerialName("modifiedByMe") val modifiedByMe: Boolean? = null,
    @SerialName("permissionIds") val permissionIds: List<String>? = null,
    @SerialName("resourceKey") val resourceKey: String? = null,
    @SerialName("sha1Checksum") val sha1Checksum: String? = null,
    @SerialName("sha256Checksum") val sha256Checksum: String? = null,
    @SerialName("contentHints") val contentHints: ContentHints? = null,
    @SerialName("lastModifyingUser") val lastModifyingUser: GApiDriveUser? = null,
    @SerialName("owners") val owners: List<GApiDriveUser>? = null,
    @SerialName("sharingUser") val sharingUser: GApiDriveUser? = null,
    @SerialName("capabilities") val capabilities: Capabilities? = null,
    @SerialName("trashingUser") val trashingUser: GApiDriveUser? = null,
    @SerialName("imageMediaMetadata") val imageMediaMetadata: ImageMediaMetadata? = null,
    @SerialName("videoMediaMetadata") val videoMediaMetadata: VideoMediaMetadata? = null,
    @SerialName("shortcutDetails") val shortcutDetails: ShortcutDetails? = null,
    @SerialName("linkShareMetadata") val linkShareMetadata: LinkShareMetadata? = null,
    @SerialName("permissions") val permissions: List<GApiDrivePermission>? = null,
    @SerialName("contentRestrictions") val contentRestrictions: List<GApiDriveContentRestriction>? = null,
    @SerialName("labelInfo") val labelInfo: LabelInfo? = null
) {
    @Serializable
    data class ContentHints(
        @SerialName("indexableText") val indexableText: String? = null,
        @SerialName("thumbnail") val thumbnail: Thumbnail? = null
    ) {
        @Serializable
        data class Thumbnail(
            @SerialName("image") val image: String? = null,
            @SerialName("mimeType") val mimeType: String? = null
        )
    }

    @Serializable
    data class Capabilities(
        @SerialName("canChangeViewersCanCopyContent") val canChangeViewersCanCopyContent: Boolean? = null,
        @SerialName("canMoveChildrenOutOfDrive") val canMoveChildrenOutOfDrive: Boolean? = null,
        @SerialName("canReadDrive") val canReadDrive: Boolean? = null,
        @SerialName("canEdit") val canEdit: Boolean? = null,
        @SerialName("canCopy") val canCopy: Boolean? = null,
        @SerialName("canComment") val canComment: Boolean? = null,
        @SerialName("canAddChildren") val canAddChildren: Boolean? = null,
        @SerialName("canDelete") val canDelete: Boolean? = null,
        @SerialName("canDownload") val canDownload: Boolean? = null,
        @SerialName("canListChildren") val canListChildren: Boolean? = null,
        @SerialName("canRemoveChildren") val canRemoveChildren: Boolean? = null,
        @SerialName("canRename") val canRename: Boolean? = null,
        @SerialName("canTrash") val canTrash: Boolean? = null,
        @SerialName("canReadRevisions") val canReadRevisions: Boolean? = null,
        @SerialName("canReadTeamDrive") val canReadTeamDrive: Boolean? = null,
        @SerialName("canMoveTeamDriveItem") val canMoveTeamDriveItem: Boolean? = null,
        @SerialName("canChangeCopyRequiresWriterPermission") val canChangeCopyRequiresWriterPermission: Boolean? = null,
        @SerialName("canMoveItemIntoTeamDrive") val canMoveItemIntoTeamDrive: Boolean? = null,
        @SerialName("canUntrash") val canUntrash: Boolean? = null,
        @SerialName("canModifyContent") val canModifyContent: Boolean? = null,
        @SerialName("canMoveItemWithinTeamDrive") val canMoveItemWithinTeamDrive: Boolean? = null,
        @SerialName("canMoveItemOutOfTeamDrive") val canMoveItemOutOfTeamDrive: Boolean? = null,
        @SerialName("canDeleteChildren") val canDeleteChildren: Boolean? = null,
        @SerialName("canMoveChildrenOutOfTeamDrive") val canMoveChildrenOutOfTeamDrive: Boolean? = null,
        @SerialName("canMoveChildrenWithinTeamDrive") val canMoveChildrenWithinTeamDrive: Boolean? = null,
        @SerialName("canTrashChildren") val canTrashChildren: Boolean? = null,
        @SerialName("canMoveItemOutOfDrive") val canMoveItemOutOfDrive: Boolean? = null,
        @SerialName("canAddMyDriveParent") val canAddMyDriveParent: Boolean? = null,
        @SerialName("canRemoveMyDriveParent") val canRemoveMyDriveParent: Boolean? = null,
        @SerialName("canMoveItemWithinDrive") val canMoveItemWithinDrive: Boolean? = null,
        @SerialName("canShare") val canShare: Boolean? = null,
        @SerialName("canMoveChildrenWithinDrive") val canMoveChildrenWithinDrive: Boolean? = null,
        @SerialName("canModifyContentRestriction") val canModifyContentRestriction: Boolean? = null,
        @SerialName("canAddFolderFromAnotherDrive") val canAddFolderFromAnotherDrive: Boolean? = null,
        @SerialName("canChangeSecurityUpdateEnabled") val canChangeSecurityUpdateEnabled: Boolean? = null,
        @SerialName("canAcceptOwnership") val canAcceptOwnership: Boolean? = null,
        @SerialName("canReadLabels") val canReadLabels: Boolean? = null,
        @SerialName("canModifyLabels") val canModifyLabels: Boolean? = null,
        @SerialName("canModifyEditorContentRestriction") val canModifyEditorContentRestriction: Boolean? = null,
        @SerialName("canModifyOwnerContentRestriction") val canModifyOwnerContentRestriction: Boolean? = null,
        @SerialName("canRemoveContentRestriction") val canRemoveContentRestriction: Boolean? = null
    )

    @Serializable
    data class ImageMediaMetadata(
        @SerialName("flashUsed") val flashUsed: Boolean? = null,
        @SerialName("meteringMode") val meteringMode: String? = null,
        @SerialName("sensor") val sensor: String? = null,
        @SerialName("exposureMode") val exposureMode: String? = null,
        @SerialName("colorSpace") val colorSpace: String? = null,
        @SerialName("whiteBalance") val whiteBalance: String? = null,
        @SerialName("width") val width: Int? = null,
        @SerialName("height") val height: Int? = null,
        @SerialName("location") val location: Location? = null,
        @SerialName("rotation") val rotation: Int? = null,
        @SerialName("time") val time: String? = null,
        @SerialName("cameraMake") val cameraMake: String? = null,
        @SerialName("cameraModel") val cameraModel: String? = null,
        @SerialName("exposureTime") val exposureTime: Double? = null,
        @SerialName("aperture") val aperture: Double? = null,
        @SerialName("focalLength") val focalLength: Double? = null,
        @SerialName("isoSpeed") val isoSpeed: Int? = null,
        @SerialName("exposureBias") val exposureBias: Double? = null,
        @SerialName("maxApertureValue") val maxApertureValue: Double? = null,
        @SerialName("subjectDistance") val subjectDistance: Int? = null,
        @SerialName("lens") val lens: String? = null
    ) {
        @Serializable
        data class Location(
            @SerialName("latitude") val latitude: Double? = null,
            @SerialName("longitude") val longitude: Double? = null,
            @SerialName("altitude") val altitude: Double? = null
        )
    }

    @Serializable
    data class VideoMediaMetadata(
        @SerialName("width") val width: Int? = null,
        @SerialName("height") val height: Int? = null,
        @SerialName("durationMillis") val durationMillis: String? = null
    )

    @Serializable
    data class ShortcutDetails(
        @SerialName("targetId") val targetId: String? = null,
        @SerialName("targetMimeType") val targetMimeType: String? = null,
        @SerialName("targetResourceKey") val targetResourceKey: String? = null
    )

    @Serializable
    data class LinkShareMetadata(
        @SerialName("securityUpdateEligible") val securityUpdateEligible: Boolean? = null,
        @SerialName("securityUpdateEnabled") val securityUpdateEnabled: Boolean? = null
    )

    @Serializable
    data class LabelInfo(@SerialName("labels") val labels: List<GApiDriveLabel>? = null)
}
