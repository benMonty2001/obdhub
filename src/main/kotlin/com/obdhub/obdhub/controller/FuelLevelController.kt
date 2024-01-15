package com.obdhub.obdhub.controller

import com.obdhub.obdhub.request.FuelLevelRequest
import com.obdhub.obdhub.response.FuelLevelResponse
import com.obdhub.obdhub.service.FuelLevelService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/fuellevel")
class FuelLevelController(@Autowired val fuelLevelService: FuelLevelService) {

    @GetMapping
    @ResponseBody
    fun getFuelLevels(): List<FuelLevelResponse> {
        val fuelLevelList = fuelLevelService.getFuelLevels()
        return fuelLevelList.map { fuelLevel ->
            FuelLevelResponse(
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

    @PostMapping
    @ResponseBody
    fun postFuelLevel(@RequestBody fuelLevelRequest: FuelLevelRequest): FuelLevelResponse {
        return fuelLevelService.saveFuelLevel(fuelLevelRequest)
    }
}
