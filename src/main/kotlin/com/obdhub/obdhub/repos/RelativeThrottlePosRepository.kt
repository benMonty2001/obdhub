package com.obdhub.obdhub.repos

import com.obdhub.obdhub.domain.RelativeThrottlePos
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository


interface RelativeThrottlePosRepository : JpaRepository<RelativeThrottlePos, UUID>
