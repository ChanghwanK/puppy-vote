package kr.puppy.vote.auth.mapper

import kr.puppy.vote.auth.domain.Authentication
import kr.puppy.vote.auth.entity.AuthenticationJpaEntity
import org.springframework.stereotype.Component

@Component
class AuthenticationMapper {

    fun mapToJpaEntity(authentication: Authentication): AuthenticationJpaEntity {
        return AuthenticationJpaEntity(
            principal = authentication.principal,
            credential = authentication.credential
        )
    }
}