package com.obdhub.obdhub.controller

import com.obdhub.obdhub.domain.Speed
import com.obdhub.obdhub.repos.SpeedRepository
import com.obdhub.obdhub.repos.TagRepository
import com.obdhub.obdhub.repos.VehicleRepository
import com.obdhub.obdhub.request.SpeedRequest
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import java.time.OffsetDateTime
import java.util.*

@Controller
class SpeedController(
		@Autowired val speedRepository: SpeedRepository,
		@Autowired val vehicleRepository: VehicleRepository,
		@Autowired val tagRepository: TagRepository
) {

	@GetMapping("/speed")
	@ResponseBody
	fun getSpeedData(): List<Speed> = speedRepository.findAll()

	@PostMapping("/speed")
	@ResponseBody
	fun postSpeedData(@RequestBody speedRequest: SpeedRequest) {
		val vehicleFetched = vehicleRepository.findById(UUID.fromString(speedRequest.vehicleId))
				.orElseThrow { EntityNotFoundException("Vehicle not found with ID: ${speedRequest.vehicleId}") }

		val tagFetched = tagRepository.findById(UUID.fromString(speedRequest.tagId))
				.orElseThrow { EntityNotFoundException("Tag not found with ID: ${speedRequest.tagId}") }

		val speed = Speed().apply {
			createdAt = OffsetDateTime.parse(speedRequest.createdAt)
			value = speedRequest.value
			defaultUnit = speedRequest.defaultUnit
			id = UUID.fromString(speedRequest.id)
			uploadId = UUID.fromString(speedRequest.uploadId)
			vehicle = vehicleFetched
			tag = tagFetched
		}

		speedRepository.save(speed)
	}
}