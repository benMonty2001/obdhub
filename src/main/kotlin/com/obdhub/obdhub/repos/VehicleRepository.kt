package com.obdhub.obdhub.repos

import com.obdhub.obdhub.domain.Vehicle
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository


interface VehicleRepository : JpaRepository<Vehicle, UUID>
