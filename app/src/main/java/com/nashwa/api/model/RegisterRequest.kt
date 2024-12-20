package com.nashwa.api.model

data class RegisterRequest (
    val username : String,
    val password : String,
    val fullname : String,
    val email : String
)
