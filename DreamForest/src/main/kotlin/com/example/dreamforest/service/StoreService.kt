package com.example.dreamforest.service

import com.example.dreamforest.dto.StoreGetDTO
import com.example.dreamforest.repository.StoreRepository
import org.springframework.stereotype.Service

@Service
class StoreService (val storeRepository: StoreRepository){
    fun findStoreByStoreId(store_id : Long) : Any{
        val entity = storeRepository.findById(store_id).orElseThrow {
            IllegalArgumentException("해당 화장실은 존재하지 않습니다. id=$store_id")
        }

        return StoreGetDTO(entity)
    }

    fun findNearStore( user_x : Double, user_y : Double) : MutableList<StoreGetDTO> {
        val result = mutableListOf<StoreGetDTO>()
        val storeInfoProjections = storeRepository.findNearStore(user_x,user_y) ?: return result
        for (storeInfoProjection in storeInfoProjections) {
            val storeInfoDto = StoreGetDTO(storeInfoProjection)
            result.add(storeInfoDto)
        }
        return result
    }
}