package com.obdhub.obdhub.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement


@Configuration
@EntityScan("com.obdhub.obdhub.domain")
@EnableJpaRepositories("com.obdhub.obdhub.repos")
@EnableTransactionManagement
class DomainConfig
