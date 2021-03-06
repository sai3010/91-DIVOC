package com.hackertronix.model.countries


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity
data class Location(
    @PrimaryKey(autoGenerate = false)
    @Json(name = "id")
    val id: Int = 0,

    @Json(name = "country")
    val country: String = "",

    @Json(name = "country_code")
    val countryCode: String = "",

    @Json(name = "province")
    val province: String = "",

    @Json(name = "last_updated")
    val lastUpdated: String = "",

    @Embedded(prefix = "latest")
    @Json(name = "latest")
    val latest: Latest = Latest(),

    @Embedded(prefix = "timelines")
    @Json(name = "timelines")
    val timelines: Timelines = Timelines()
)