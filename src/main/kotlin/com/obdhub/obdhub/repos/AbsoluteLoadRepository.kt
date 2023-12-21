package com.obdhub.obdhub.repos

import com.obdhub.obdhub.domain.AbsoluteLoad
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository


interface AbsoluteLoadRepository : JpaRepository<AbsoluteLoad, UUID>
