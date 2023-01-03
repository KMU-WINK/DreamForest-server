package com.example.dreamforest.repository

import com.example.dreamforest.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long> {
    fun findByEmail(email:String): User?
}