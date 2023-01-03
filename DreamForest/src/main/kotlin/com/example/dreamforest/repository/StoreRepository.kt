package com.example.dreamforest.repository

import com.example.dreamforest.entity.Store
import org.springframework.data.jpa.repository.JpaRepository

interface StoreRepository: JpaRepository<Store, Long> {
}