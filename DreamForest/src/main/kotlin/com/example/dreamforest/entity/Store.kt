package com.example.dreamforest.entity

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
    var store_update_date: String? = null,
    var latitude: Double? = null,
    var longitude: Double? = null,
) {
}