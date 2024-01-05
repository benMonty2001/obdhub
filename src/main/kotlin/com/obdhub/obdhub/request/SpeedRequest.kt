package com.obdhub.obdhub.request

data class SpeedRequest(
		val vehicleId: String,
		val createdAt: String,
		val tagId: String,
		val value: Long,
		val defaultUnit: String,
		val id: String,
		val uploadId: String
)