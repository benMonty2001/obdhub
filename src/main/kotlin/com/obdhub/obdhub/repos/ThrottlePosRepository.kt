package com.obdhub.obdhub.repos

import com.obdhub.obdhub.domain.ThrottlePos
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository


interface ThrottlePosRepository : JpaRepository<ThrottlePos, UUID>
