package com.bitwanted.demo

import io.ktor.application.*
import io.ktor.features.CallLogging
import io.ktor.features.DefaultHeaders
import io.ktor.http.*
import io.ktor.routing.*
import io.ktor.response.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*



fun main(args: Array<String>) {
    embeddedServer(Netty, 18080) {
        routing {
            get("/") {
                call.respondText("Hello, world!", ContentType.Text.Html)
            }
        }
    }.start(wait = true)
}


