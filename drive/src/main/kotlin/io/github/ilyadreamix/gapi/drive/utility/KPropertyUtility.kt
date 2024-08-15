package io.github.ilyadreamix.gapi.drive.utility

import kotlinx.serialization.SerialName
import kotlin.reflect.KProperty

internal fun KProperty<*>.findSerialName(): String {
    val annotation = this.annotations.first { it is SerialName } as SerialName
    return annotation.value
}
