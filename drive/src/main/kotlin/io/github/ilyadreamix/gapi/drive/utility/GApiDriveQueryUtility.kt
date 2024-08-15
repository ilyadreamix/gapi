package io.github.ilyadreamix.gapi.drive.utility

class GApiDriveQueryBuilder {

    private val queryParts = mutableListOf<String>()

    infix fun String.stringEquals(other: String): GApiDriveQueryBuilder {
        queryParts += "$this='$other'"
        return this@GApiDriveQueryBuilder
    }

    infix fun String.fieldEquals(other: String): GApiDriveQueryBuilder {
        queryParts += "$this=$other"
        return this@GApiDriveQueryBuilder
    }

    infix fun String.contains(other: String): GApiDriveQueryBuilder {
        queryParts += "'$other' in $this"
        return this@GApiDriveQueryBuilder
    }

    infix fun append(query: String): GApiDriveQueryBuilder {
        queryParts += query
        return this@GApiDriveQueryBuilder
    }

    fun build() = queryParts.joinToString(" and ")
}

inline fun buildDriveQuery(builder: GApiDriveQueryBuilder.() -> Unit): String {
    val builderImpl = GApiDriveQueryBuilder()
    builderImpl.apply(builder)
    return builderImpl.build()
}
