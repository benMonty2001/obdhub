package com.obdhub.obdhub.service

import com.obdhub.obdhub.domain.EngineLoad
import com.obdhub.obdhub.domain.Tag
import com.obdhub.obdhub.domain.Vehicle
import com.obdhub.obdhub.repos.EngineLoadRepository
import com.obdhub.obdhub.request.EngineLoadRequest
import com.obdhub.obdhub.response.EngineLoadResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import java.util.*

@Service
class EngineLoadService(@Autowired val engineLoadRepository: EngineLoadRepository) {
    fun getEngineLoads(): List<EngineLoad> = engineLoadRepository.findAll()

    fun saveEngineLoad(engineLoadRequest: EngineLoadRequest): EngineLoadResponse {
        val engineLoad = engineLoadRepository.save(
            EngineLoad().apply {
                createdAt = OffsetDateTime.parse(engineLoadRequest.createdAt)
                value = engineLoadRequest.value.toDouble()
                defaultUnit = engineLoadRequest.defaultUnit
                uploadId = UUID.fromString(engineLoadRequest.uploadId)
                tag = Tag().apply { tagId = UUID.fromString(engineLoadRequest.tagId) }
                vehicle = Vehicle().apply { id = UUID.fromString(engineLoadRequest.vehicleId) }
            }
        )

        return EngineLoadResponse(
            id = engineLoad.id.toString(),
            createdAt = engineLoad.createdAt.toString(),
            value = engineLoad.value.toString(),
            defaultUnit = engineLoad.defaultUnit.toString(),
            uploadId = engineLoad.uploadId.toString(),
            tagId = engineLoad.tag?.tagId.toString(),
            vehicleId = engineLoad.vehicle?.id.toString()
        )
    }
}
