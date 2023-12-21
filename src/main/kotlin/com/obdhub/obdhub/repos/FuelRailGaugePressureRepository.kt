package com.obdhub.obdhub.repos

import com.obdhub.obdhub.domain.FuelRailGaugePressure
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository


interface FuelRailGaugePressureRepository : JpaRepository<FuelRailGaugePressure, UUID>
