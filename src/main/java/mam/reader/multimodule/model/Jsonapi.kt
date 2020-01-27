package mam.reader.multimodule.model

import com.google.gson.annotations.SerializedName

data class Jsonapi(
    @SerializedName("version")
    val version: String?
)