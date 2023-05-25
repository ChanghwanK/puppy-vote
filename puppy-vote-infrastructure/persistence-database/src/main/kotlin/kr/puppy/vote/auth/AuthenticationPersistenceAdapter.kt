package kr.puppy.vote.auth

import kr.puppy.vote.auth.domain.Authentication
import kr.puppy.vote.auth.mapper.AuthenticationMapper
import org.springframework.stereotype.Component
import kr.puppy.vote.auth.port.AuthenticationPersistencePort
import kr.puppy.vote.auth.repository.AuthenticationRepository

@Component
class AuthenticationPersistenceAdapter(
    val authenticationMapper: AuthenticationMapper,
    val authenticationRepository: AuthenticationRepository,
) : AuthenticationPersistencePort {

    override fun save(authentication: Authentication) {
        authenticationRepository.save(authenticationMapper.mapToJpaEntity(authentication))
    }
}