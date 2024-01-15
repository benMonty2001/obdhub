package com.obdhub.obdhub.controller

import com.obdhub.obdhub.request.SpeedRequest
import com.obdhub.obdhub.response.SpeedResponse
import com.obdhub.obdhub.service.SpeedService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/speed")
class SpeedController(@Autowired val speedService: SpeedService) {

	@GetMapping
	@ResponseBody
	fun getSpeeds(): List<SpeedResponse> {
		val speeds = speedService.getSpeeds()
		return speeds.map { speed ->
			SpeedResponse(
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

	@PostMapping
	@ResponseBody
	fun postSpeed(@RequestBody speedRequest: SpeedRequest): SpeedResponse {
		return speedService.saveSpeed(speedRequest)
	}
}
