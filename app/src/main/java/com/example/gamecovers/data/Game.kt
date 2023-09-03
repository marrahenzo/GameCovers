package com.example.gamecovers.data

data class Game(
    val id: Long,
    val name: String,
    val developer: String,
    val platform: String,
    val releaseDate: String,
    val permalink: String
) {
    override fun toString(): String {
        return "$id - $name - $developer - $releaseDate"
    }
}