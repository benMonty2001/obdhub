package com.obdhub.obdhub.controller

import com.obdhub.obdhub.domain.Vehicle
import com.obdhub.obdhub.repos.VehicleRepository
import com.obdhub.obdhub.request.VehicleRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class VehicleController(@Autowired val vehicleRepository: VehicleRepository) {

    @GetMapping("/vehicles")
    @ResponseBody
    fun getVehicles(): List<Vehicle> = vehicleRepository.findAll()

    @PostMapping("/vehicles")
    @ResponseBody
    fun postVehicle(@RequestBody vehicleRequest: VehicleRequest): Vehicle {
        val vehicle = Vehicle().apply {
            vin = vehicleRequest.vin
        }

        //TODO just throw an appropriate exception if the value is blank
        //TODO before saving do some validation to make sure the existing vin does not exist. There is a unique constraint. For now, since we are not targetting exceptions, just return the existing one instead of saving.

        vehicleRepository.save(vehicle)

        return vehicle
    }
}
