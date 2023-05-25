package kr.puppy.vote.auth

import kr.puppy.vote.auth.domain.Authentication
import kr.puppy.vote.auth.mapper.AuthenticationMapper
import kr.puppy.vote.auth.port.AuthenticationExistsChecker
import kr.puppy.vote.auth.port.AuthenticationPersistencePort
import kr.puppy.vote.auth.repository.AuthenticationRepository
import org.springframework.stereotype.Component

@Component
class AuthenticationPersistenceAdapter(
    val authenticationMapper: AuthenticationMapper,
    val authenticationRepository: AuthenticationRepository,
) : AuthenticationPersistencePort, AuthenticationExistsChecker {

    override fun save(authentication: Authentication) {
        authenticationRepository.save(authenticationMapper.mapToJpaEntity(authentication))
    }

    override fun existsByPrincipal(principal: String) {
        val res = authenticationRepository.existsByPrincipal(principal)
        if (res) {
            throw IllegalArgumentException("중복된 이메일 입니다.")
        }
    }
}