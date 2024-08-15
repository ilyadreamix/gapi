package io.github.ilyadreamix.gapi.common.service

enum class GApiServiceType(val url: String) {
    Drive("https://www.googleapis.com/drive/v3"),
    Sheets("https://docs.google.com/spreadsheets/d");
}
