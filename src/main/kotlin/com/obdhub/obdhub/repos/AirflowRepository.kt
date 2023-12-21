package com.obdhub.obdhub.repos

import com.obdhub.obdhub.domain.Airflow
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository


interface AirflowRepository : JpaRepository<Airflow, UUID>
