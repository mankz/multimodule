package mam.reader.multimodule.model

import com.google.gson.annotations.SerializedName

data class Books(
    @SerializedName("data")
    val data : MutableList<BookData>?,
    @SerializedName("jsonapi")
    val jsonapi: Jsonapi?,
    @SerializedName("links")
    val links: Links?,
    @SerializedName("meta")
    val meta: Meta?
)