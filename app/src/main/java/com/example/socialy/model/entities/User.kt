package com.example.socialy.model.entities

data class User(
    val id: String,
    val name: String,
    val username: String,
    val bio: String,
    val email: String,
    val profilePicture: String,
) {
    constructor(
        id: String,
        name: String,
        username: String,
        email: String
    ) : this(id, name, username, "", email, "")
}
