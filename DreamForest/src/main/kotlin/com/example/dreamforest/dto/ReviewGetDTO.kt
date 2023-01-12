package com.example.dreamforest.dto

import com.example.dreamforest.entity.Naver_reviews
import java.io.Serializable
import java.util.*
import javax.persistence.Column

class ReviewGetDTO (
    var naver_place_id: Long? = null,
    var review_id: String? = null,
    var rating: Float? = null,
    var user_id: String? = null,
    var user_nickname: String? = null,
    var user_from: String? = null,
    var user_image_url: String? = null,
    var user_object_id: String? = null,
    var user_url: String? = null,
    var review_body: String? = null,
    @Column(columnDefinition = "json")
    var review_image: String? = null,
    var visit_date: Date? = null,
    var visit_type: String? = null,
    var visit_count: Long? = null,
    ) : Serializable {
    constructor(entity: Naver_reviews) : this(entity.naver_place_id, entity.review_id, entity.rating, entity.user_id, entity.user_nickname, entity.user_from, entity.user_image_url, entity.user_object_id, entity.user_url, entity.review_body, entity.review_image, entity.visit_date,entity.visit_type, entity.visit_count)
}