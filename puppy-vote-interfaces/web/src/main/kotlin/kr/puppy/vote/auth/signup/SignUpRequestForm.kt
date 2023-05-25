package kr.puppy.vote.auth.signup

import kr.puppy.vote.auth.usecase.Command

data class SignUpRequestForm(
    val email: String,
    val password: String,
) {
    fun toCommand(): Command {
        return Command(email = email, password = password)
    }
}
