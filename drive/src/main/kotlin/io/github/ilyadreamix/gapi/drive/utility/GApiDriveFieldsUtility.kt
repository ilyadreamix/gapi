package io.github.ilyadreamix.gapi.drive.utility

import io.github.ilyadreamix.gapi.common.utility.Comma
import kotlin.reflect.KProperty

inline fun buildDriveFields(builder: GApiDriveFieldsBuilder.() -> Unit): String {
    val builderImpl = GApiDriveFieldsBuilder()
    builderImpl.apply(builder)
    return builderImpl.build()
}

class GApiDriveFieldsBuilder {

    private val parts = mutableListOf<String>()

    fun select(vararg fields: KProperty<*>): GApiDriveFieldsBuilder {
        val fieldsNames = fields.map { it.findSerialName() }
        parts += fieldsNames
        return this
    }

    fun select(fields: List<KProperty<*>>) = select(*fields.toTypedArray())

    fun selectAll(vararg fields: KProperty<*>): GApiDriveFieldsBuilder {
        val fieldsNames = fields.map { it.findSerialName() + "(*)" }
        parts += fieldsNames
        return this
    }

    fun KProperty<*>.select(vararg fields: KProperty<*>): GApiDriveFieldsBuilder {
        val parentFieldName = this.findSerialName()
        val fieldsNames = fields.joinToString(String.Comma) { it.findSerialName() }
        parts += "$parentFieldName($fieldsNames)"
        return this@GApiDriveFieldsBuilder
    }

    infix fun KProperty<*>.select(field: KProperty<*>) = this.select(*arrayOf(field))

    infix fun KProperty<*>.select(fields: List<KProperty<*>>) = this.select(*fields.toTypedArray())

    fun append(other: String): GApiDriveFieldsBuilder {
        parts += other
        return this
    }

    fun build() = parts.joinToString(",")
}
