package kr.puppy.vote.auth.port

interface AuthenticationExistsChecker {
    fun existsByPrincipal(principal: String)
}