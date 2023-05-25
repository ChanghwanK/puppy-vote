package kr.puppy.vote.auth.port

import kr.puppy.vote.auth.domain.Authentication

interface AuthenticationPersistencePort {
    fun save(authentication: Authentication)
}