package com.example.dreamforest.controller

import com.example.dreamforest.dto.LoginDTO
import com.example.dreamforest.dto.Message
import com.example.dreamforest.dto.SignupDTO
import com.example.dreamforest.model.User
import com.example.dreamforest.service.UserService
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("api/users")
class AuthController(private val userService: UserService) {

    @PostMapping("signup")
    fun singup(@RequestBody body: SignupDTO): ResponseEntity<User> {
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

    @GetMapping("user")
    fun user(@CookieValue("jwt") jwt: String?): ResponseEntity<Any> {
        try {
            if (jwt == null) {
                return ResponseEntity.status(401).body(Message("unauth"))
            }

            val body = Jwts.parser().setSigningKey("secret").parseClaimsJws(jwt).body

            return ResponseEntity.ok(this.userService.getById(body.issuer.toInt()))
        } catch (e: Exception) {
            return ResponseEntity.status(401).body(Message("unauth"))
        }
    }

    @PostMapping("logout")
    fun logout(response: HttpServletResponse): ResponseEntity<Any> {
        val cookie = Cookie("jwt", "")
        cookie.maxAge = 0

        response.addCookie(cookie)

        return ResponseEntity.ok(Message("success"))
    }

}