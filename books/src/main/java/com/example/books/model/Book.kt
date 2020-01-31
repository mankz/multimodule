package com.example.books.model


import com.google.gson.annotations.SerializedName
import mam.reader.multimodule.model.Jsonapi
import mam.reader.multimodule.model.Links
import mam.reader.multimodule.model.Meta

data class Book(
    @SerializedName("data")
    val data : BookData?,
    @SerializedName("jsonapi")
    val jsonapi: Jsonapi?,
    @SerializedName("links")
    val links: Links?,
    @SerializedName("meta")
    val meta: Meta?
)