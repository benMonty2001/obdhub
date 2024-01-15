package com.obdhub.obdhub.service

import com.obdhub.obdhub.domain.FuelLevel
import com.obdhub.obdhub.domain.Tag
import com.obdhub.obdhub.domain.Vehicle
import com.obdhub.obdhub.repos.FuelLevelRepository
import com.obdhub.obdhub.request.FuelLevelRequest
import com.obdhub.obdhub.response.FuelLevelResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import java.util.*

@Service
class FuelLevelService(@Autowired val fuelLevelRepository: FuelLevelRepository) {
    fun getFuelLevels(): List<FuelLevel> = fuelLevelRepository.findAll()

    fun saveFuelLevel(fuelLevelRequest: FuelLevelRequest): FuelLevelResponse {
        val fuelLevel = fuelLevelRepository.save(
            FuelLevel().apply {
                createdAt = OffsetDateTime.parse(fuelLevelRequest.createdAt)
                value = fuelLevelRequest.value.toDouble()
                defaultUnit = fuelLevelRequest.defaultUnit
                uploadId = UUID.fromString(fuelLevelRequest.uploadId)
                tag = Tag().apply { tagId = UUID.fromString(fuelLevelRequest.tagId) }
                vehicle = Vehicle().apply { id = UUID.fromString(fuelLevelRequest.vehicleId) }
            }
        )

        return FuelLevelResponse(
            id = fuelLevel.id.toString(),
            createdAt = fuelLevel.createdAt.toString(),
            value = fuelLevel.value.toString(),
            defaultUnit = fuelLevel.defaultUnit.toString(),
            uploadId = fuelLevel.uploadId.toString(),
            tagId = fuelLevel.tag?.tagId.toString(),
            vehicleId = fuelLevel.vehicle?.id.toString()
        )
    }
}
