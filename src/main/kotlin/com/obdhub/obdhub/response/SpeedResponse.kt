package com.obdhub.obdhub.response

data class SpeedResponse(
    val id: String,
    val createdAt: String,
    val value: String,
    val defaultUnit: String,
    val uploadId: String,
    val tagId: String,
    val vehicleId: String
)