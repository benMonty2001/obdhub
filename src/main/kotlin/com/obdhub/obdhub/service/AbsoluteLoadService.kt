package com.obdhub.obdhub.service

import com.obdhub.obdhub.domain.AbsoluteLoad
import com.obdhub.obdhub.domain.Tag
import com.obdhub.obdhub.domain.Vehicle
import com.obdhub.obdhub.repos.AbsoluteLoadRepository
import com.obdhub.obdhub.response.AbsoluteLoadRequest
import com.obdhub.obdhub.response.AbsoluteLoadResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import java.util.*

@Service
class AbsoluteLoadService(@Autowired val absoluteLoadRepository: AbsoluteLoadRepository) {
    fun getAbsoluteLoads(): List<AbsoluteLoad> = absoluteLoadRepository.findAll()

    fun saveAbsoluteLoad(absoluteLoadRequest: AbsoluteLoadRequest): AbsoluteLoadResponse {
        val absoluteLoad = absoluteLoadRepository.save(
            AbsoluteLoad().apply {
                createdAt = OffsetDateTime.parse(absoluteLoadRequest.createdAt)
                value = absoluteLoadRequest.value.toDouble()
                defaultUnit = absoluteLoadRequest.defaultUnit
                uploadId = UUID.fromString(absoluteLoadRequest.uploadId)
                tag = Tag().apply { tagId = UUID.fromString(absoluteLoadRequest.tagId) }
                vehicle = Vehicle().apply { id = UUID.fromString(absoluteLoadRequest.vehicleId) }
            }
        )

        return AbsoluteLoadResponse(
            id = absoluteLoad.id.toString(),
            createdAt = absoluteLoad.createdAt.toString(),
            value = absoluteLoad.value.toString(),
            defaultUnit = absoluteLoad.defaultUnit.toString(),
            uploadId = absoluteLoad.uploadId.toString(),
            tagId = absoluteLoad.tag?.tagId.toString(),
            vehicleId = absoluteLoad.vehicle?.id.toString()
        )
    }
}
