package com.obdhub.obdhub.repos

import com.obdhub.obdhub.domain.FuelConsumptionRate
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository


interface FuelConsumptionRateRepository : JpaRepository<FuelConsumptionRate, UUID>
