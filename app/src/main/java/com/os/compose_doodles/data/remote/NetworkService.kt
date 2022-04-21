package com.os.compose_doodles.data.remote

import com.os.compose_doodles.data.remote.model.PassengerResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

object NetworkService {

    private const val BASE_URL = "https://api.instantwebtools.net/v1/passenger"

    @OptIn(ExperimentalSerializationApi::class)
    private val client = HttpClient(CIO) {
        expectSuccess = false
        engine {
            requestTimeout = 6000000
        }

        defaultRequest {
            headers.append("Accept", "application/json")
            contentType(ContentType.Application.Json)
        }

        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
                explicitNulls = false
            })
        }

        install(Logging) {
            level = LogLevel.ALL
        }


    }

    suspend fun getPassengers(page: Int, pageSize: Int = 100): PassengerResponse {
        return client.get(BASE_URL, block = {
            parameter("page", page)
            parameter("size", pageSize)
        }).body()
    }
}