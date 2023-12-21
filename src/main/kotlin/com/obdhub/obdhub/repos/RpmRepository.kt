package com.obdhub.obdhub.repos

import com.obdhub.obdhub.domain.Rpm
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository


interface RpmRepository : JpaRepository<Rpm, UUID>
