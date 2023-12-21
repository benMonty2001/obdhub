package com.obdhub.obdhub.repos

import com.obdhub.obdhub.domain.OilTemperature
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository


interface OilTemperatureRepository : JpaRepository<OilTemperature, UUID>
