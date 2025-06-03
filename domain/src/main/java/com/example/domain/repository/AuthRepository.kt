package com.example.domain.repository

import com.example.domain.Entity.AuthResponseEntity

interface AuthRepository {
    suspend fun login(email: String, password: String): AuthResponseEntity

    suspend fun register(
        email: String,
        password: String,
        phoneNumber: String,
        fullName: String
    ): AuthResponseEntity
}

interface AuthOnlineDataSource {
    suspend fun login(email: String, password: String): AuthResponseEntity

    suspend fun register(
        email: String,
        password: String,
        phoneNumber: String,
        fullName: String
    ): AuthResponseEntity
}