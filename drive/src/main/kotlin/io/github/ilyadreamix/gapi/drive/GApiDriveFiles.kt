package io.github.ilyadreamix.gapi.drive

import io.github.ilyadreamix.gapi.common.utility.Comma
import io.github.ilyadreamix.gapi.common.utility.checkIsSuccess
import io.github.ilyadreamix.gapi.common.utility.getBytesOrThrow
import io.github.ilyadreamix.gapi.common.utility.getOrThrow
import io.github.ilyadreamix.gapi.core.service.GApiService
import io.github.ilyadreamix.gapi.core.service.GApiServiceType
import io.github.ilyadreamix.gapi.drive.enums.GApiDriveCorpora
import io.github.ilyadreamix.gapi.drive.enums.GApiDrivePermissionForView
import io.github.ilyadreamix.gapi.drive.enums.GApiDriveSortKey
import io.github.ilyadreamix.gapi.drive.enums.GApiDriveSpace
import io.github.ilyadreamix.gapi.drive.model.GApiDriveFile
import io.github.ilyadreamix.gapi.drive.model.GApiDriveFileList
import io.github.ilyadreamix.gapi.drive.utility.buildDriveFields
import io.github.ilyadreamix.gapi.drive.utility.buildDriveQuery
import io.ktor.client.request.*
import io.ktor.client.request.forms.*
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.contentType
import io.ktor.http.headersOf
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

/**
 * Rest resource: `files`
 *
 * **See Also:** [Official documentation](https://developers.google.com/drive/api/reference/rest/v3/files)
 */
class GApiDriveFiles internal constructor(accessToken: String) : GApiService(GApiServiceType.Drive, accessToken) {
    /**
     * Lists the user's files.
     * @param fields Determines exact [GApiDriveFile] fields that you need. See [buildDriveFields].
     * @param corpora Bodies of items (files/documents) to which the query applies.
     * @param driveId ID of the shared drive to search.
     * @param includeItemsFromAllDrives Whether both My Drive and shared drive items should be included in results.
     * @param orderBy Set of sort keys.
     * @param pageSize The maximum number of files to return per page. Partial or empty result pages are possible even
     * before the end of the files list has been reached.
     * @param pageToken The token for continuing a previous list request on the next page. This should be set to the
     * value of [GApiDriveFileList.nextPageToken] from the previous response.
     * @param query A query for filtering the file results. See [buildDriveQuery].
     * @param spaces A comma-separated list of spaces to query within the [corpora].
     * @param supportsAllDrives Whether the requesting application supports both My Drives and shared drives.
     * @param permissionForView Specifies which additional view's permissions to include in the response.
     * @param labelsIds Set of IDs of labels to include in the [GApiDriveFile.labelInfo] part of the response.
     */
    suspend fun list(
        fields: String? = "*",
        corpora: GApiDriveCorpora? = null,
        driveId: String? = null,
        includeItemsFromAllDrives: Boolean? = null,
        orderBy: Set<GApiDriveSortKey>? = null,
        pageSize: Int? = null,
        pageToken: String? = null,
        query: String? = null,
        spaces: Set<GApiDriveSpace>? = null,
        supportsAllDrives: Boolean? = null,
        permissionForView: GApiDrivePermissionForView? = null,
        labelsIds: Set<String>? = null
    ): GApiDriveFileList {
        val response = httpClient.get("files") {
            parameter("fields", fields)
            parameter("corpora", corpora?.value)
            parameter("driveId", driveId)
            parameter("includeItemsFromAllDrives", includeItemsFromAllDrives)
            parameter("pageSize", pageSize)
            parameter("pageToken", pageToken)
            parameter("supportsAllDrives", supportsAllDrives)
            parameter("includePermissionsForView", permissionForView?.value)

            if (orderBy != null) {
                val orderByParameter = orderBy.joinToString(String.Comma) { it.value }
                parameter("orderBy", orderByParameter)
            }

            if (query != null) {
                parameter("q", query)
            }

            if (spaces != null) {
                val spacesParameter = spaces.joinToString(String.Comma) { it.value }
                parameter("spaces", spacesParameter)
            }

            if (labelsIds != null) {
                val labelsIdsParameter = labelsIds.joinToString(String.Comma)
                parameter("includeLabels", labelsIdsParameter)
            }
        }

        return response.getOrThrow()
    }

    /**
     * Gets a file's metadata.
     * @param fileId The ID of the file.
     * @param fields Determines exact [GApiDriveFile] fields that you need. See [buildDriveFields].
     * @param supportsAllDrives Whether the requesting application supports both My Drives and shared drives.
     * @param permissionForView Specifies which additional view's permissions to include in the response.
     * @param labelsIds Set of IDs of labels to include in the [GApiDriveFile.labelInfo] part of the response.
     */
    suspend fun getMetadata(
        fileId: String,
        fields: String? = "*",
        supportsAllDrives: Boolean? = null,
        permissionForView: GApiDrivePermissionForView? = null,
        labelsIds: Set<String>? = null
    ): GApiDriveFile {
        val response = httpClient.get("files/$fileId") {
            parameter("fileId", fileId)
            parameter("fields", fields)
            parameter("supportsAllDrives", supportsAllDrives)
            parameter("includePermissionsForView", permissionForView?.value)

            if (labelsIds != null) {
                val labelsIdsParameter = labelsIds.joinToString(String.Comma)
                parameter("includeLabels", labelsIdsParameter)
            }
        }

        return response.getOrThrow()
    }

    /**
     * Gets a file's content.
     * @param fileId The ID of the file.
     * @param acknowledgeAbuse Whether the user is acknowledging the risk of downloading known malware or other abusive
     * files. This is only applicable when the user is the owner of the file or an organizer of the shared drive in
     * which the file resides.
     * @param supportsAllDrives Whether the requesting application supports both My Drives and shared drives.
     * @param permissionForView Specifies which additional view's permissions to include in the response.
     * @param labelsIds Set of IDs of labels to include in the [GApiDriveFile.labelInfo] part of the response.
     */
    suspend fun getContent(
        fileId: String,
        acknowledgeAbuse: Boolean? = null,
        supportsAllDrives: Boolean? = null,
        permissionForView: GApiDrivePermissionForView? = null,
        labelsIds: Set<String>? = null
    ): ByteArray {
        val response = httpClient.get("files/$fileId") {
            parameter("alt", "media")
            parameter("acknowledgeAbuse", acknowledgeAbuse)
            parameter("supportsAllDrives", supportsAllDrives)
            parameter("includePermissionsForView", permissionForView?.value)

            if (labelsIds != null) {
                val labelsIdsParameter = labelsIds.joinToString(String.Comma)
                parameter("includeLabels", labelsIdsParameter)
            }
        }

        return response.getBytesOrThrow()
    }

    /**
     * Permanently deletes a file owned by the user without moving it to the trash. If the file belongs to a shared
     * drive, the user must be an `organizer` on the parent folder. If the target is a folder, all descendants owned by
     * the user are also deleted.
     * @param fileId The ID of the file.
     * @param supportsAllDrives Whether the requesting application supports both My Drives and shared drives.
     */
    suspend fun delete(fileId: String, supportsAllDrives: Boolean? = null) {
        val response = httpClient.delete("files/$fileId") {
            parameter("supportsAllDrives", supportsAllDrives)
        }

        response.checkIsSuccess()
    }

    /**
     * Simple upload. Upload the media only, without any metadata.
     * @param content Contents of the file to upload.
     * @param contentType MIME type of the [content].
     * @param fields Determines exact [GApiDriveFile] fields that you need. See [buildDriveFields].
     * @param ignoreDefaultVisibility Whether to ignore the domain's default visibility settings for the created file.
     * Domain administrators can choose to make all uploaded files visible to the domain by default;
     * this parameter bypasses that behavior for the request. Permissions are still inherited from parent folders.
     * @param keepRevisionForever Whether to set the `keepForever` field in the new head revision.
     * This is only applicable to files with binary content in Google Drive. Only 200 revisions for the file can be
     * kept forever. If the limit is reached, try deleting pinned revisions.
     * @param ocrLanguage A language hint for OCR processing during image import (ISO 639-1 code).
     * @param supportsAllDrives Whether the requesting application supports both My Drives and shared drives.
     * @param useContentAsIndexableText Whether to use the uploaded content as indexable text.
     * @param permissionForView Specifies which additional view's permissions to include in the response.
     * @param labelsIds Set of IDs of labels to include in the [GApiDriveFile.labelInfo] part of the response.
     */
    suspend fun uploadMedia(
        content: ByteArray,
        contentType: ContentType,
        fields: String? = null,
        ignoreDefaultVisibility: Boolean? = null,
        keepRevisionForever: Boolean? = null,
        ocrLanguage: String? = null,
        supportsAllDrives: Boolean? = null,
        useContentAsIndexableText: Boolean? = null,
        permissionForView: GApiDrivePermissionForView? = null,
        labelsIds: Set<String>? = null
    ): GApiDriveFile {
        val response = httpClient.post(
            url = UploadEndpoint,
            overrideUrl = true
        ) {
            parameter("uploadType", "media")
            parameter("fields", fields)
            parameter("ignoreDefaultVisibility", ignoreDefaultVisibility)
            parameter("keepRevisionForever", keepRevisionForever)
            parameter("ocrLanguage", ocrLanguage)
            parameter("supportsAllDrives", supportsAllDrives)
            parameter("useContentAsIndexableText", useContentAsIndexableText)
            parameter("includePermissionsForView", permissionForView?.value)

            if (labelsIds != null) {
                val labelsIdsParameter = labelsIds.joinToString(String.Comma)
                parameter("includeLabels", labelsIdsParameter)
            }

            setBody(content)
            contentType(contentType)
        }

        return response.getOrThrow()
    }

    /**
     * Multipart upload. Upload both the media and its metadata, in a single request.
     * @param metadata Metadata of the file to upload.
     * @param content Contents of the file to upload.
     * @param contentType MIME type of the [content].
     * @param fields Determines exact [GApiDriveFile] fields that you need. See [buildDriveFields].
     * @param ignoreDefaultVisibility Whether to ignore the domain's default visibility settings for the created file.
     * Domain administrators can choose to make all uploaded files visible to the domain by default;
     * this parameter bypasses that behavior for the request. Permissions are still inherited from parent folders.
     * @param keepRevisionForever Whether to set the `keepForever` field in the new head revision.
     * This is only applicable to files with binary content in Google Drive. Only 200 revisions for the file can be
     * kept forever. If the limit is reached, try deleting pinned revisions.
     * @param ocrLanguage A language hint for OCR processing during image import (ISO 639-1 code).
     * @param supportsAllDrives Whether the requesting application supports both My Drives and shared drives.
     * @param useContentAsIndexableText Whether to use the uploaded content as indexable text.
     * @param permissionForView Specifies which additional view's permissions to include in the response.
     * @param labelsIds Set of IDs of labels to include in the [GApiDriveFile.labelInfo] part of the response.
     */
    suspend fun uploadMultipart(
        metadata: GApiDriveFile,
        content: ByteArray,
        contentType: ContentType,
        fields: String? = null,
        ignoreDefaultVisibility: Boolean? = null,
        keepRevisionForever: Boolean? = null,
        ocrLanguage: String? = null,
        supportsAllDrives: Boolean? = null,
        useContentAsIndexableText: Boolean? = null,
        permissionForView: GApiDrivePermissionForView? = null,
        labelsIds: Set<String>? = null
    ): GApiDriveFile {
        val response = httpClient.submitFormWithBinaryData(
            url = UploadEndpoint,
            overrideUrl = true,
            formData = formData {
                append(
                    key = "metadata",
                    value = Json.encodeToString(metadata),
                    headers = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.toString())
                )
                append(
                    key = "data",
                    value = content,
                    headers = headersOf(HttpHeaders.ContentType, contentType.toString())
                )
            }
        ) {
            parameter("uploadType", "multipart")
            parameter("fields", fields)
            parameter("ignoreDefaultVisibility", ignoreDefaultVisibility)
            parameter("keepRevisionForever", keepRevisionForever)
            parameter("ocrLanguage", ocrLanguage)
            parameter("supportsAllDrives", supportsAllDrives)
            parameter("useContentAsIndexableText", useContentAsIndexableText)
            parameter("includePermissionsForView", permissionForView?.value)

            if (labelsIds != null) {
                val labelsIdsParameter = labelsIds.joinToString(String.Comma)
                parameter("includeLabels", labelsIdsParameter)
            }
        }

        return response.getOrThrow()
    }

    /**
     * Creates a new file.
     * @param file File to create.
     * @param fields Determines exact [GApiDriveFile] fields that you need. See [buildDriveFields].
     * @param ignoreDefaultVisibility Whether to ignore the domain's default visibility settings for the created file.
     * Domain administrators can choose to make all uploaded files visible to the domain by default;
     * this parameter bypasses that behavior for the request. Permissions are still inherited from parent folders.
     * @param keepRevisionForever Whether to set the `keepForever` field in the new head revision.
     * This is only applicable to files with binary content in Google Drive. Only 200 revisions for the file can be
     * kept forever. If the limit is reached, try deleting pinned revisions.
     * @param ocrLanguage A language hint for OCR processing during image import (ISO 639-1 code).
     * @param supportsAllDrives Whether the requesting application supports both My Drives and shared drives.
     * @param useContentAsIndexableText Whether to use the uploaded content as indexable text.
     * @param permissionForView Specifies which additional view's permissions to include in the response.
     * @param labelsIds Set of IDs of labels to include in the [GApiDriveFile.labelInfo] part of the response.
     */
    suspend fun create(
        file: GApiDriveFile,
        fields: String? = null,
        ignoreDefaultVisibility: Boolean? = null,
        keepRevisionForever: Boolean? = null,
        ocrLanguage: String? = null,
        supportsAllDrives: Boolean? = null,
        useContentAsIndexableText: Boolean? = null,
        permissionForView: GApiDrivePermissionForView? = null,
        labelsIds: Set<String>? = null
    ): GApiDriveFile {
        val response = httpClient.post("files") {
            parameter("uploadType", "multipart")
            parameter("fields", fields)
            parameter("ignoreDefaultVisibility", ignoreDefaultVisibility)
            parameter("keepRevisionForever", keepRevisionForever)
            parameter("ocrLanguage", ocrLanguage)
            parameter("supportsAllDrives", supportsAllDrives)
            parameter("useContentAsIndexableText", useContentAsIndexableText)
            parameter("includePermissionsForView", permissionForView?.value)

            if (labelsIds != null) {
                val labelsIdsParameter = labelsIds.joinToString(String.Comma)
                parameter("includeLabels", labelsIdsParameter)
            }

            setBody(file)
            contentType(ContentType.Application.Json)
        }

        return response.getOrThrow()
    }

    companion object {
        private const val UploadEndpoint = "https://www.googleapis.com/upload/drive/v3/files"
    }
}
