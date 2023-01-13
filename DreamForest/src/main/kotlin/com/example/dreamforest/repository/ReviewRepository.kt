package com.example.dreamforest.repository

import com.example.dreamforest.entity.Naver_reviews
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface ReviewRepository: JpaRepository<Naver_reviews, Long> {
    fun findByStoreId(store_id: Long) : Optional<List<Naver_reviews>>
}