package kr.puppy.vote.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.SecretKey

const val TWELVE_HOURS_IN_MILLISECONDS: Long = 1000 * 60 * 60 * 12

@Component
class JwtManager(
    private val signingKey: SecretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256),
    private val expirationInMilliseconds: Long = TWELVE_HOURS_IN_MILLISECONDS
) {

    fun createToken(payload: String): String {
        val claims: Claims = Jwts.claims().setSubject(payload)
        val now = Date()
        val expiration = Date(now.time + expirationInMilliseconds)
        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(expiration)
            .signWith(signingKey)
            .compact()
    }
}