package me.tadebois.entain.nedapi

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("status") val status: Int,
    @SerializedName("data") val data: ApiData,
    @SerializedName("message") val message: String
)

data class ApiData(
    @SerializedName("next_to_go_ids") val nextToGoIds: List<String>,
    @SerializedName("race_summaries") val raceSummaries: Map<String, RaceSummary>
)

data class RaceSummary(
    @SerializedName("race_id") val raceId: String,
    @SerializedName("race_name") val raceName: String,
    @SerializedName("race_number") val raceNumber: Int,
    @SerializedName("meeting_id") val meetingId: String,
    @SerializedName("meeting_name") val meetingName: String,
    @SerializedName("category_id") val categoryId: String,
    @SerializedName("advertised_start") val advertisedStart: AdvertisedStart,
    @SerializedName("race_form") val raceForm: RaceForm,
    @SerializedName("venue_id") val venueId: String,
    @SerializedName("venue_name") val venueName: String,
    @SerializedName("venue_state") val venueState: String,
    @SerializedName("venue_country") val venueCountry: String
)

data class AdvertisedStart(
    @SerializedName("seconds") val seconds: Long
)

data class RaceForm(
    @SerializedName("distance") val distance: Int,
    @SerializedName("distance_type") val distanceType: DistanceType,
    @SerializedName("distance_type_id") val distanceTypeId: String,
    @SerializedName("track_condition") val trackCondition: TrackCondition,
    @SerializedName("track_condition_id") val trackConditionId: String,
    @SerializedName("weather") val weather: Weather,
    @SerializedName("weather_id") val weatherId: String,
    @SerializedName("race_comment") val raceComment: String,
    @SerializedName("additional_data") val additionalData: String,
    @SerializedName("generated") val generated: Int,
    @SerializedName("silk_base_url") val silkBaseUrl: String,
    @SerializedName("race_comment_alternative") val raceCommentAlternative: String
)

data class DistanceType(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("short_name") val shortName: String
)

data class TrackCondition(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("short_name") val shortName: String
)

data class Weather(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("short_name") val shortName: String,
    @SerializedName("icon_uri") val iconUri: String
)
