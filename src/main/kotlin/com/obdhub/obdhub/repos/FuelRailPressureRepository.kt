package com.obdhub.obdhub.repos

import com.obdhub.obdhub.domain.FuelRailPressure
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository


interface FuelRailPressureRepository : JpaRepository<FuelRailPressure, UUID>
