package com.obdhub.obdhub.repos

import com.obdhub.obdhub.domain.TimingAdvance
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository


interface TimingAdvanceRepository : JpaRepository<TimingAdvance, UUID>
