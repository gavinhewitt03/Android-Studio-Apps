package com.example.marsphotos.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MarsPhoto(
    val id: String,
    @SerialName(value = "img_src") 
    val imgSrc: String // tells serialization converter that imgSrc
    // corresponds to img_src in the JSON because underscores go against kotlin naming guidelines
)