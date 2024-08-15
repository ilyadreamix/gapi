package io.github.ilyadreamix.gapi.drive.utility

import kotlin.reflect.KProperty

inline fun buildDriveQuery(builder: GApiDriveQueryBuilder.() -> Unit): String {
    val builderImpl = GApiDriveQueryBuilder()
    builderImpl.apply(builder)
    return builderImpl.build()
}

class GApiDriveQueryBuilder {

    private val queryParts = mutableListOf<String>()

    infix fun KProperty<*>.equalTo(other: Any?): GApiDriveQueryBuilder {
        if (other is String) {
            queryParts += "${this.findSerialName()}='$other'"
        } else {
            queryParts += "${this.findSerialName()}=${other?.toString()}"
        }
        return this@GApiDriveQueryBuilder
    }

    fun append(query: String): GApiDriveQueryBuilder {
        queryParts += query
        return this@GApiDriveQueryBuilder
    }

    fun build() = queryParts.joinToString(" and ")
}
