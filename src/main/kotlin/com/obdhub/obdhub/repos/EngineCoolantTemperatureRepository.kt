package com.obdhub.obdhub.repos

import com.obdhub.obdhub.domain.EngineCoolantTemperature
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository


interface EngineCoolantTemperatureRepository : JpaRepository<EngineCoolantTemperature, UUID>
