package com.obdhub.obdhub.repos

import com.obdhub.obdhub.domain.Tag
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository


interface TagRepository : JpaRepository<Tag, UUID>
