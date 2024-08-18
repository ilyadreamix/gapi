package io.github.ilyadreamix.gapi.core.etc

import io.github.ilyadreamix.gapi.core.service.GApiServiceType
import io.github.oshai.kotlinlogging.KotlinLogging.logger

internal val GApiServiceType.logger get() = when (this) {
    GApiServiceType.Drive -> DriveLogger
    GApiServiceType.Sheets -> SheetsLogger
}

private val DriveLogger = logger("DriveLogger")
private val SheetsLogger = logger("SheetsLogger")
