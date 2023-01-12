package com.example.dreamforest.service

import com.example.dreamforest.dto.ReviewGetDTO
import com.example.dreamforest.repository.ReviewRepository
import org.springframework.stereotype.Service

@Service
class ReviewService(val reviewRepository: ReviewRepository) {
    fun findReviewByStoreId(store_id : Long) : MutableList<ReviewGetDTO>{
        val entities = reviewRepository.findByStoreId(store_id).orElseThrow {
            IllegalArgumentException("해당 화장실은 존재하지 않습니다. id=$store_id")
        }

        val result = mutableListOf<ReviewGetDTO>()

        for(entity in entities) {
            result.add(ReviewGetDTO(entity))
        }

        return result
    }
}