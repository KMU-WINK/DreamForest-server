package com.example.dreamforest.controller

import com.example.dreamforest.dto.*
import com.example.dreamforest.entity.User
import com.example.dreamforest.service.UserService
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("user")
class AuthController(private val userService: UserService) {

    @PostMapping("signup")
    fun singup(@RequestBody body: SignupDTO): ResponseEntity<Any> {
        val userexist = this.userService.findByEmail(body.email)
        if(userexist != null){
            return ResponseEntity.badRequest().body(Message("user is exist!"))
        }
        val user = User()
        user.email = body.email
        user.name = body.name
        user.nickname = body.nickname
        user.password = body.password
        return ResponseEntity.ok(this.userService.save(user))
    }

    @PostMapping("login")
    fun login(@RequestBody body: LoginDTO, response: HttpServletResponse): ResponseEntity<Any>{
        val user = this.userService.findByEmail(body.email)
            ?: return ResponseEntity.badRequest().body(Message("user not found!"))

        if (!user.comparePassword(body.password)){
            return ResponseEntity.badRequest().body(Message("password is wrong!"))
        }

        val issuer = user.id.toString()

        val jwt = Jwts.builder()
            .setIssuer(issuer)
            .setExpiration(Date(System.currentTimeMillis() + 60 * 24 * 1000))
            .signWith(SignatureAlgorithm.HS512, "secret").compact()

        val cookie = Cookie("jwt", jwt)
        cookie.isHttpOnly = true
        response.addCookie(cookie)

        return ResponseEntity.ok(Message(jwt))
    }

    @PostMapping("info")
    fun user(@RequestBody jwt: UserDTO?): ResponseEntity<Any> {
        try {
            if (jwt == null) {
                return ResponseEntity.status(401).body(Message("jwtnull"))
            }

            val body = Jwts.parser().setSigningKey("secret").parseClaimsJws(jwt.token).body

            return ResponseEntity.ok(this.userService.getById(body.issuer.toLong()))
        } catch (e: Exception) {
            return ResponseEntity.status(401).body(Message("wrong auth"))
        }
    }

    @PutMapping("update/{user_id}")
    fun updateUserInfo(@PathVariable user_id : Long, @RequestBody userUpdateDTO: UserUpdateDTO) : Long? {
        return userService.updateUserInfo(user_id, userUpdateDTO)
    }

    @PostMapping("logout")
    fun logout(response: HttpServletResponse): ResponseEntity<Any> {
        val cookie = Cookie("jwt", "")
        cookie.maxAge = 0

        response.addCookie(cookie)

        return ResponseEntity.ok(Message("success"))
    }

}