package kr.puppy.vote.auth.repository

import kr.puppy.vote.auth.entity.AuthenticationJpaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AuthenticationRepository : JpaRepository<AuthenticationJpaEntity, Long> {
}