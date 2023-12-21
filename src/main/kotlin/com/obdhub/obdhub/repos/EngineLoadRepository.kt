package com.obdhub.obdhub.repos

import com.obdhub.obdhub.domain.EngineLoad
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository


interface EngineLoadRepository : JpaRepository<EngineLoad, UUID>
