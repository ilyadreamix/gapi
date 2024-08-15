package io.github.ilyadreamix.gapi.drive.enums

enum class GApiDriveSortKey(val value: String) {
    CreatedTime("createdTime"),
    CreatedTimeDescending("createdTime desc"),
    Folder("folder"),
    FolderDescending("folder desc"),
    ModifiedByMeTime("modifiedByMeTime"),
    ModifiedByMeTimeDescending("modifiedByMeTime desc"),
    ModifiedTime("modifiedTime"),
    ModifiedTimeDescending("modifiedTime desc"),
    Name("name"),
    NameDescending("name desc"),
    NameNatural("name_natural"),
    NameNaturalDescending("name_natural desc"),
    QuotaBytesUsed("quotaBytesUsed"),
    QuotaBytesUsedDescending("quotaBytesUsed desc"),
    Recency("recency"),
    RecencyDescending("recency desc"),
    SharedWithMeTime("sharedWithMeTime"),
    SharedWithMeTimeDescending("sharedWithMeTime desc"),
    Starred("starred"),
    StarredDescending("starred desc"),
    ViewedByMeTime("viewedByMeTime"),
    ViewedByMeTimeDescending("viewedByMeTime desc");
}
