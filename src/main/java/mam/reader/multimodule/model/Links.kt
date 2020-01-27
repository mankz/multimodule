package mam.reader.multimodule.model

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("self")
    val self: String?
)