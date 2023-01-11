package com.example.dreamforest.entity

import java.util.Date
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Naver_reviews(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,
    var stores_id: Long? = null,
    var review_id: String? = null,
    var rating: Float? = null,
    var user_id: String? = null,
    var user_nickname: String? = null,
    var user_from: String? = null,
    var user_image_url: String? = null,
    var user_object_id: String? = null,
    var user_url: String? = null,
    var review_body: String? = null,
    var review_image: String? = null,
    var visit_date: Date? = null,
    var visit_type: String? = null,
    var visit_count: Long? = null,
) {
}