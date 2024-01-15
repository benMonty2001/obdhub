package com.obdhub.obdhub.service

import com.obdhub.obdhub.domain.Tag
import com.obdhub.obdhub.domain.ThrottlePos
import com.obdhub.obdhub.domain.Vehicle
import com.obdhub.obdhub.repos.ThrottlePosRepository
import com.obdhub.obdhub.response.ThrottlePosRequest
import com.obdhub.obdhub.response.ThrottlePosResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import java.util.*

@Service
class ThrottlePosService(@Autowired val throttlePosRepository: ThrottlePosRepository) {
    fun getThrottlePos(): List<ThrottlePos> = throttlePosRepository.findAll()

    fun saveThrottlePos(throttlePosRequest: ThrottlePosRequest): ThrottlePosResponse {
        val throttlePos = throttlePosRepository.save(
            ThrottlePos().apply {
                createdAt = OffsetDateTime.parse(throttlePosRequest.createdAt)
                value = throttlePosRequest.value.toDouble()
                defaultUnit = throttlePosRequest.defaultUnit
                uploadId = UUID.fromString(throttlePosRequest.uploadId)
                tag = Tag().apply { tagId = UUID.fromString(throttlePosRequest.tagId) }
                vehicle = Vehicle().apply { id = UUID.fromString(throttlePosRequest.vehicleId) }
            }
        )

        return ThrottlePosResponse(
            id = throttlePos.id.toString(),
            createdAt = throttlePos.createdAt.toString(),
            value = throttlePos.value.toString(),
            defaultUnit = throttlePos.defaultUnit.toString(),
            uploadId = throttlePos.uploadId.toString(),
            tagId = throttlePos.tag?.tagId.toString(),
            vehicleId = throttlePos.vehicle?.id.toString()
        )
    }
}
