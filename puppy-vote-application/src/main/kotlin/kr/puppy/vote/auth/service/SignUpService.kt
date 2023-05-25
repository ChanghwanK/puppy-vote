package kr.puppy.vote.auth.service

import kr.puppy.vote.auth.domain.Authentication
import kr.puppy.vote.auth.usecase.Command
import kr.puppy.vote.auth.usecase.SignUpUseCase
import kr.puppy.vote.auth.port.AuthenticationPersistencePort
import org.springframework.stereotype.Service

@Service
class SignUpService(
    val persistencePort: AuthenticationPersistencePort
) : SignUpUseCase {
    override fun command(command: Command) {
        val authentication = Authentication(principal = command.email, _credential = command.password)
        persistencePort.save(authentication)
    }
}