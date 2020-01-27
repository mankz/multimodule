package mam.reader.multimodule.model

import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("instance_meta")
    val instanceMeta: InstanceMeta?,
    @SerializedName("limit")
    val limit: Int?
) {

}