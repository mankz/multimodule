package mam.reader.multimodule.model

import com.google.gson.annotations.SerializedName

data class Relationships(
    @SerializedName("author")
    val author: Author?,
    @SerializedName("publisher")
    val publisher: Publisher?,
    @SerializedName("reader")
    val reader: Reader?,
    @SerializedName("reviews")
    val reviews: Reviews?
)