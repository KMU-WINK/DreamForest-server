package com.example.dreamforest.dto

import com.example.dreamforest.entity.Store
import java.io.Serializable
import java.util.Date

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
    val distance: Double? = null
) : Serializable {
    constructor(entity: Store) : this(entity.id, entity.type, entity.store_name, entity.road_address, entity.parcel_address, entity.phone_number, entity.store_update_date, entity.naver_x, entity.naver_y)
    constructor(storeInfoProjection: StoreInfoProjection) : this(storeInfoProjection.id, storeInfoProjection.type, storeInfoProjection.store_name, storeInfoProjection.road_address, storeInfoProjection.parcel_address, storeInfoProjection.phone_number, storeInfoProjection.store_update_date, storeInfoProjection.naver_x, storeInfoProjection.naver_y, storeInfoProjection.distance)
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
    val distance : Double?
}