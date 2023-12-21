package com.obdhub.obdhub.repos

import com.obdhub.obdhub.domain.AmbientAirTemperature
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository


interface AmbientAirTemperatureRepository : JpaRepository<AmbientAirTemperature, UUID>
