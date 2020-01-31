package com.example.books.model

import com.google.gson.annotations.SerializedName
import mam.reader.multimodule.model.Attributes
import mam.reader.multimodule.model.Links
import mam.reader.multimodule.model.Relationships

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