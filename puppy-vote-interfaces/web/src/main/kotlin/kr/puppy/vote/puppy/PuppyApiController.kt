package kr.puppy.vote.puppy

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PuppyApiController {

    @PostMapping("/api/v1/puppy")
    fun registerPuppy(): String {
        return "hello puppy"
    }
}