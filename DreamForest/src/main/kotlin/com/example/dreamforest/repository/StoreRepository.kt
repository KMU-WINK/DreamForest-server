package com.example.dreamforest.repository

import com.example.dreamforest.dto.StoreInfoProjection
import com.example.dreamforest.entity.Store
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface StoreRepository: JpaRepository<Store, Long> {
    @Query("SELECT id, type, store_name, road_address, parcel_address, phone_number, store_update_date, naver_x, naver_y, ST_Distance_Sphere(POINT(:naver_x, :naver_y), POINT(naver_x, naver_y)) AS distance From store where ST_Distance_Sphere(POINT(:naver_x, :naver_y), POINT(naver_x, naver_y)) <= 30000", nativeQuery = true)
    fun findNearStore(@Param("naver_x") naver_x : Double, @Param("naver_y") naver_y : Double) : List<StoreInfoProjection>?
}