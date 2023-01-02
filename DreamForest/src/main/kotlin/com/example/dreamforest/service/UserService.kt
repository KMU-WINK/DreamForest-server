package com.example.dreamforest.service

import com.example.dreamforest.dto.UserUpdateDTO
import com.example.dreamforest.entity.User
import com.example.dreamforest.repository.UserRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class UserService(private val userRepository: UserRepository) {
    fun save(user: User): User {
        return this.userRepository.save(user)
    }

    fun findByEmail(email: String): User? {
        return this.userRepository.findByEmail(email)
    }

    fun getById(id: Long): User {
        return this.userRepository.getById(id)
    }

    @Transactional
    fun updateUserInfo(id : Long, userUpdateDTO: UserUpdateDTO) : Long? {
        val user = userRepository.findById(id).orElseThrow {
            IllegalArgumentException("해당 아이디는 존재하지 않습니다. id=$id")
        }
        user.update(userUpdateDTO)
        return id
    }
}