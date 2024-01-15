package com.obdhub.obdhub.controller

import com.obdhub.obdhub.response.VehicleRequest
import com.obdhub.obdhub.response.VehicleResponse
import com.obdhub.obdhub.service.VehicleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/vehicle")
class VehicleController(@Autowired val vehicleService: VehicleService) {

    @GetMapping
    @ResponseBody
    fun getVehicles(): List<VehicleResponse> {
        val vehicles = vehicleService.getVehicles()
        return vehicles.map { vehicle ->
            VehicleResponse(
                id = vehicle.id.toString(),
                vin = vehicle.vin.toString()
                // Add other properties as needed
            )
        }
    }

    @PostMapping
    @ResponseBody
    fun postVehicle(@RequestBody vehicleRequest: VehicleRequest): VehicleResponse {
        return vehicleService.saveVehicle(vehicleRequest)
    }
}
