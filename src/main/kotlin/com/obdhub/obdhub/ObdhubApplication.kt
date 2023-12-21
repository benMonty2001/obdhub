package com.obdhub.obdhub

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class ObdhubApplication

fun main(args: Array<String>) {
    runApplication<ObdhubApplication>(*args)
}
