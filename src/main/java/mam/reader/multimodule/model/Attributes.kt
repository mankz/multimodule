package mam.reader.multimodule.model

import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("author_id")
    val authorId: String?,
    @SerializedName("publisher_id")
    val publisherId: Int?,
    @SerializedName("reader_id")
    val readerId: String?,
    @SerializedName("title")
    val title: String?
)