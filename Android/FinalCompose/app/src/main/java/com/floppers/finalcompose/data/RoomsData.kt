package com.floppers.finalcompose.data

data class RoomsData(
    val id: Int,
    val address: String,
    val capacity: Int,
    val isempty: Boolean
)

data class Rooms(
    val address: String,
    val capacity: Int,
    val isempty: Boolean
)
