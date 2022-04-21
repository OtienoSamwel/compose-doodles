package com.os.compose_doodles.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PassengerResponse(
    val data: List<Data>,
    val totalPages: Int,
    val totalPassengers: Int
)

@Serializable
data class Data(
    @SerialName("__v") val v: Int?,
    @SerialName("id") val id: String?,
    val airline: List<Airline>,
    val name: String,
    val trips: Int
)

@Serializable
data class Airline(
    @SerialName("__v") val v: Int?,
    @SerialName("_id") val id: String?,
    val country: String,
    val established: String,
    @SerialName("head_quaters") val headquarters: String,
    @SerialName("id") val airlineId: Int,
    val logo: String,
    val name: String,
    val slogan: String,
    val website: String
)