package mam.reader.multimodule.model

import com.google.gson.annotations.SerializedName

data class Reader(
    @SerializedName("data")
    val `data`: Any?,
    @SerializedName("links")
    val links: Links?
)