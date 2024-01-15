package com.obdhub.obdhub.request

data class ThrottlePosRequest(
    val createdAt: String,
    val value: String,
    val defaultUnit: String,
    val uploadId: String,
    val tagId: String,
    val vehicleId: String
)
