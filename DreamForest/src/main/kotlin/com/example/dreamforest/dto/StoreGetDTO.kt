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
) : Serializable {
    constructor(entity: Store) : this(entity.id, entity.type, entity.store_name, entity.road_address, entity.parcel_address, entity.phone_number, entity.store_update_date, entity.naver_x, entity.naver_y)
}