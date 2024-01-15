package com.obdhub.obdhub.request

data class AbsoluteLoadRequest(
    val createdAt: String,
    val value: String,
    val defaultUnit: String,
    val uploadId: String,
    val tagId: String,
    val vehicleId: String
)
