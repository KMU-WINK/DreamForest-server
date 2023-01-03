package com.example.dreamforest.entity

import com.example.dreamforest.dto.UserUpdateDTO
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Entity
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0

    @Column(unique = true)
    var email = ""

    @Column
    var name = ""

    @Column
    var nickname = ""

    @Column
    var password = ""
        @JsonIgnore
        get() = field
        set(value) {
            val passwordEncoder = BCryptPasswordEncoder()
            field = passwordEncoder.encode(value)
        }

    fun comparePassword(password: String): Boolean {
        return BCryptPasswordEncoder().matches(password, this.password)
    }

    fun update(userUpdateDTO: UserUpdateDTO){
        this.email = userUpdateDTO.email.toString()
        this.name = userUpdateDTO.name.toString()
        this.nickname = userUpdateDTO.nickname.toString()
        this.password = userUpdateDTO.password.toString()
    }

}