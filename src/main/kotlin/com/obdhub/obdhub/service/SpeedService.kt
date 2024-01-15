package com.obdhub.obdhub.service

import com.obdhub.obdhub.domain.Speed
import com.obdhub.obdhub.domain.Tag
import com.obdhub.obdhub.domain.Vehicle
import com.obdhub.obdhub.repos.SpeedRepository
import com.obdhub.obdhub.request.SpeedRequest
import com.obdhub.obdhub.response.SpeedResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import java.util.*

@Service
class SpeedService(@Autowired val speedRepository: SpeedRepository) {
    fun getSpeeds(): List<Speed> = speedRepository.findAll()

    fun saveSpeed(speedRequest: SpeedRequest): SpeedResponse {
        val speed = speedRepository.save(
            Speed().apply {
                createdAt = OffsetDateTime.parse(speedRequest.createdAt)
                value = speedRequest.value.toLong()
                defaultUnit = speedRequest.defaultUnit
                uploadId = UUID.fromString(speedRequest.uploadId)
                tag = Tag().apply { tagId = UUID.fromString(speedRequest.tagId) }
                vehicle = Vehicle().apply { id = UUID.fromString(speedRequest.vehicleId) }
            }
        )

        return SpeedResponse(
            id = speed.id.toString(),
            createdAt = speed.createdAt.toString(),
            value = speed.value.toString(),
            defaultUnit = speed.defaultUnit.toString(),
            uploadId = speed.uploadId.toString(),
            tagId = speed.tag?.tagId.toString(),
            vehicleId = speed.vehicle?.id.toString()
        )
    }
}
