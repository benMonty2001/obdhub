package com.obdhub.obdhub.repos

import com.obdhub.obdhub.domain.IntakeManifoldPressure
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository


interface IntakeManifoldPressureRepository : JpaRepository<IntakeManifoldPressure, UUID>
