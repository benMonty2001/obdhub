package com.obdhub.obdhub.repos

import com.obdhub.obdhub.domain.AirIntakeTemperature
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository


interface AirIntakeTemperatureRepository : JpaRepository<AirIntakeTemperature, UUID>
