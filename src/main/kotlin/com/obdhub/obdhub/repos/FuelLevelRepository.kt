package com.obdhub.obdhub.repos

import com.obdhub.obdhub.domain.FuelLevel
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository


interface FuelLevelRepository : JpaRepository<FuelLevel, UUID>
