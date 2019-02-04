package ro.razvan

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
        }
    }

    routing {
        get("helloWorld"){
            call.respond("hello world")
        }
        get("helloJson"){
            call.respond(HelloWorldResponse("super", "hero"))
        }
        post(path = "helloPost"){
            call.respond("hello world post")
        }
    }

}

data class HelloWorldResponse(val name: String, val surname: String)

