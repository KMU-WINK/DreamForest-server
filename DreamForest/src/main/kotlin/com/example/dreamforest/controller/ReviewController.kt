package com.example.dreamforest.controller

import com.example.dreamforest.dto.ReviewGetDTO
import com.example.dreamforest.service.ReviewService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("review")
class ReviewController(private val reviewService: ReviewService) {

    @GetMapping("{store_id}")
    fun findReview(@PathVariable store_id: Long) : MutableList<ReviewGetDTO> {
        return reviewService.findReviewByStoreId(store_id)
    }
}