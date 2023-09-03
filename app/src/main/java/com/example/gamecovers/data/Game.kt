package com.example.gamecovers.data

data class Game(
    val id: Long,
    val name: String,
    val description: String,
    val releaseDate: String,
    val price: Double,
    val rating: Double,
    val permalink: String
) {
    override fun toString(): String {
        return "$id - $name - $${String.format("%.2f", price)} - $releaseDate"
    }
}