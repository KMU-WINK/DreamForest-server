package com.example.dreamforest.dto

import com.example.dreamforest.entity.Store
import java.io.Serializable
import java.util.Date
import javax.persistence.Column

class StoreGetDTO (
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
    @Column(columnDefinition = "json")
    var naver_categories: String? = null,
    @Column(columnDefinition = "json")
    var naver_biz_hour: String? = null,
    @Column(columnDefinition = "json")
    var naver_menus: String? = null,
    @Column(columnDefinition = "json")
    var naver_menu_images: String? = null,
    var naver_blog_review_count: Long? = null,
    var naver_average_rating: Float? = null,
    var naver_visit_review_count: Long? = null,
    var naver_updated_at: java.sql.Date? = null,
    val distance: Double? = null,
) : Serializable {
    constructor(entity: Store) : this(entity.id, entity.type, entity.store_name, entity.road_address, entity.parcel_address, entity.phone_number, entity.store_update_date, entity.naver_x, entity.naver_y, entity.naver_place_id, entity.naver_store_name, entity.naver_parcel_address, entity.naver_phone, entity.naver_categories, entity.naver_biz_hour, entity.naver_menus, entity.naver_menu_images, entity.naver_blog_review_count, entity.naver_average_rating, entity.naver_visit_review_count, entity.naver_updated_at)
    constructor(storeInfoProjection: StoreInfoProjection) : this(storeInfoProjection.id, storeInfoProjection.type, storeInfoProjection.store_name, storeInfoProjection.road_address, storeInfoProjection.parcel_address, storeInfoProjection.phone_number, storeInfoProjection.store_update_date, storeInfoProjection.naver_x, storeInfoProjection.naver_y,  storeInfoProjection.naver_place_id, storeInfoProjection.naver_store_name, storeInfoProjection.naver_parcel_address, storeInfoProjection.naver_phone, storeInfoProjection.naver_categories, storeInfoProjection.naver_biz_hour, storeInfoProjection.naver_menus, storeInfoProjection.naver_menu_images, storeInfoProjection.naver_blog_review_count, storeInfoProjection.naver_average_rating, storeInfoProjection.naver_visit_review_count, storeInfoProjection.naver_updated_at, storeInfoProjection.distance)
}

interface StoreInfoProjection {
    var id : Long
    var type: String?
    var store_name: String?
    var road_address: String?
    var parcel_address: String?
    var phone_number: String?
    var store_update_date: Date?
    var naver_x: Double?
    var naver_y: Double?
    var naver_place_id: Long?
    var naver_store_name: String?
    var naver_parcel_address: String?
    var naver_phone: String?
    var naver_categories: String?
    var naver_biz_hour: String?
    var naver_menus: String?
    var naver_menu_images: String?
    var naver_blog_review_count: Long?
    var naver_average_rating: Float?
    var naver_visit_review_count: Long?
    var naver_updated_at: java.sql.Date?
    val distance : Double?
}