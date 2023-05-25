package kr.puppy.vote.auth.usecase

data class Command(
    val email: String,
    val password: String
)

interface SignUpUseCase {
    fun command(command: Command)
}