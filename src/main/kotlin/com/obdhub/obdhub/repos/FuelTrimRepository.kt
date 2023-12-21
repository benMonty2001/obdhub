package com.obdhub.obdhub.repos

import com.obdhub.obdhub.domain.FuelTrim
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository


interface FuelTrimRepository : JpaRepository<FuelTrim, UUID>
