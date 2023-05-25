package kr.puppy.vote.auth.service

import kr.puppy.vote.auth.domain.Authentication
import kr.puppy.vote.auth.port.AuthenticationExistsChecker
import kr.puppy.vote.auth.port.AuthenticationPersistencePort
import kr.puppy.vote.auth.usecase.Command
import kr.puppy.vote.auth.usecase.SignUpUseCase
import org.springframework.stereotype.Service

@Service
class SignUpService(
    private val persistencePort: AuthenticationPersistencePort,
    private val authenticationExistsChecker: AuthenticationExistsChecker,
) : SignUpUseCase {
    override fun command(command: Command) {
        authenticationExistsChecker.existsByPrincipal(command.email)

        val authentication = Authentication(principal = command.email, _credential = command.password)
        persistencePort.save(authentication)
    }
}