package io.github.ilyadreamix.gapi.drive

import io.github.ilyadreamix.gapi.common.service.GApiService
import io.github.ilyadreamix.gapi.common.service.GApiServiceType
import io.github.ilyadreamix.gapi.common.utility.Comma
import io.github.ilyadreamix.gapi.common.utility.getOrThrow
import io.github.ilyadreamix.gapi.drive.enums.GApiDriveCorpora
import io.github.ilyadreamix.gapi.drive.enums.GApiDrivePermissionForView
import io.github.ilyadreamix.gapi.drive.enums.GApiDriveSortKey
import io.github.ilyadreamix.gapi.drive.enums.GApiDriveSpace
import io.github.ilyadreamix.gapi.drive.model.GApiDriveFileList
import io.github.ilyadreamix.gapi.drive.utility.buildDriveQuery
import io.ktor.client.request.*

class GApiDriveFiles internal constructor(accessToken: String) : GApiService(GApiServiceType.Drive, accessToken) {
    /**
     * Lists the user's files.
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
     * @param permissionForView wSpecifies which additional view's permissions to include in the response.
     * @param labelsIds Set of IDs of labels to include in the labelInfo part of the response.
     */
    suspend fun list(
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
}
