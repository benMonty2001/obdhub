package com.obdhub.obdhub.repos

import com.obdhub.obdhub.domain.ModuleVoltage
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository


interface ModuleVoltageRepository : JpaRepository<ModuleVoltage, UUID>
