package com.obdhub.obdhub.repos

import com.obdhub.obdhub.domain.BarometricPressure
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository


interface BarometricPressureRepository : JpaRepository<BarometricPressure, UUID>
