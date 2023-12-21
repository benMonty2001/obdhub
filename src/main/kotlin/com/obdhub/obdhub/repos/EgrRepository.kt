package com.obdhub.obdhub.repos

import com.obdhub.obdhub.domain.Egr
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository


interface EgrRepository : JpaRepository<Egr, UUID>
