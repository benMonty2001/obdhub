package com.obdhub.obdhub.repos

import com.obdhub.obdhub.domain.EthanolLevel
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository


interface EthanolLevelRepository : JpaRepository<EthanolLevel, UUID>
