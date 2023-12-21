package com.obdhub.obdhub.repos

import com.obdhub.obdhub.domain.FuelType
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository


interface FuelTypeRepository : JpaRepository<FuelType, UUID>
