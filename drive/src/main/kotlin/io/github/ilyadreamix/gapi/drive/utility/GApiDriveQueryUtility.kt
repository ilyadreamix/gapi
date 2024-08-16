package io.github.ilyadreamix.gapi.drive.utility

import kotlin.reflect.KProperty

inline fun buildDriveQuery(builder: GApiDriveQueryBuilder.() -> Unit): String {
    val builderImpl = GApiDriveQueryBuilder()
    builderImpl.apply(builder)
    return builderImpl.build()
}

class GApiDriveQueryBuilder {

    private val queryParts = mutableListOf<String>()

    infix fun KProperty<*>.equalTo(other: Any): GApiDriveQueryBuilder {
        if (other is String) {
            queryParts += "${this.findSerialName()}='$other'"
        } else {
            queryParts += "${this.findSerialName()}=$other"
        }
        return this@GApiDriveQueryBuilder
    }

    infix fun KProperty<*>.contains(other: Any): GApiDriveQueryBuilder {
        if (other is String) {
            queryParts += "'$other' in ${this.findSerialName()}"
        } else {
            queryParts += "$other in ${this.findSerialName()}"
        }
        return this@GApiDriveQueryBuilder
    }

    infix fun KProperty<*>.equalTo(other: Any?) {
        if (other != null) {
            this.equalTo(other)
        }
    }

    infix fun KProperty<*>.contains(other: Any?) {
        if (other != null) {
            this.contains(other)
        }
    }

    fun append(query: String): GApiDriveQueryBuilder {
        queryParts += query
        return this@GApiDriveQueryBuilder
    }

    fun build() = queryParts.joinToString(" and ")
}
