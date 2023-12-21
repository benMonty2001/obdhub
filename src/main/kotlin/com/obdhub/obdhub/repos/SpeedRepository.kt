package com.obdhub.obdhub.repos

import com.obdhub.obdhub.domain.Speed
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository


interface SpeedRepository : JpaRepository<Speed, UUID>
