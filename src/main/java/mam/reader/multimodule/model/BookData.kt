package mam.reader.multimodule.model

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class BookData(
    @SerializedName("attributes")
    val attributes: Attributes?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("links")
    val links: Links?,
    @SerializedName("relationships")
    val relationships: Relationships?,
    @SerializedName("type")
    val type: String?
)