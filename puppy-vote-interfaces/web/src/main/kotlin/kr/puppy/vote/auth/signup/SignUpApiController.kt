package kr.puppy.vote.auth.signup

import kr.puppy.vote.auth.usecase.SignUpUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SignUpApiController(
    private val signupUseCase: SignUpUseCase
) {
    @PostMapping("/api/v1/signup")
    fun signUp(@RequestBody signUpForm: SignUpRequestForm) {
        signupUseCase.command(signUpForm.toCommand())
    }
}