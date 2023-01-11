package com.example.dreamforest.entity

import java.awt.Image
import java.sql.Date
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Store(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,
    var type: String? = null,
    var store_name: String? = null,
    var road_address: String? = null,
    var parcel_address: String? = null,
    var phone_number: String? = null,
    var store_update_date: Date? = null,
    var naver_x: Double? = null,
    var naver_y: Double? = null,
    var naver_place_id: Long? = null,
    var naver_store_name: String? = null,
    var naver_parcel_address: String? = null,
    var naver_phone: String? = null,
    var naver_categories: String? = null,
    var naver_biz_hour: String? = null,
    var naver_menus: String? = null,
    var naver_menu_images: String? = null,
    var naver_blog_review_count: Long? = null,
    var naver_update_at: Date? = null,
    var naver_average_rating: Float? = null,
    var naver_visit_review_count: Long? = null,
) {
}