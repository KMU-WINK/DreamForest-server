package com.example.dreamforest.controller

import com.example.dreamforest.dto.StoreGetDTO
import com.example.dreamforest.service.StoreService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("store")
class StoreController(private val storeService: StoreService) {

    @GetMapping("detail/{store_id}")
    fun findStore(@PathVariable store_id : Long) : Any{
        return storeService.findStoreByStoreId(store_id)
    }

    @GetMapping("search")
    fun findNearStore(@RequestParam user_x : Double, @RequestParam user_y : Double) : MutableList<StoreGetDTO> {
        return storeService.findNearStore(user_x, user_y)
    }
}