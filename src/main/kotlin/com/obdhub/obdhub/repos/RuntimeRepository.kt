package com.obdhub.obdhub.repos

import com.obdhub.obdhub.domain.Runtime
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository


interface RuntimeRepository : JpaRepository<Runtime, UUID>
