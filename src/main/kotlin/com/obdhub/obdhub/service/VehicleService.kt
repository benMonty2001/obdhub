package com.obdhub.obdhub.service

import com.obdhub.obdhub.domain.Vehicle
import com.obdhub.obdhub.repos.VehicleRepository
import com.obdhub.obdhub.response.VehicleRequest
import com.obdhub.obdhub.response.VehicleResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class VehicleService(@Autowired val vehicleRepository: VehicleRepository) {
    fun getVehicles(): List<Vehicle> = vehicleRepository.findAll()

    fun saveVehicle(vehicleRequest: VehicleRequest): VehicleResponse {
        val vehicle = vehicleRepository.save(
            Vehicle().apply {
                vin = vehicleRequest.vin
                // Add other properties as needed
            }
        )

        return VehicleResponse(
            id = vehicle.id.toString(),
            vin = vehicle.vin.toString()
            // Add other properties as needed
        )
    }
}
