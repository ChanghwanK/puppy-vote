package kr.puppy.vote.auth.service

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.*
import kr.puppy.vote.auth.port.AuthenticationExistsChecker
import kr.puppy.vote.auth.port.AuthenticationPersistencePort
import kr.puppy.vote.auth.usecase.Command

class SignUpServiceTest : BehaviorSpec({
    val persistencePort = mockk<AuthenticationPersistencePort>()
    val existsChecker = mockk<AuthenticationExistsChecker>()
    lateinit var sut: SignUpService
    beforeTest {
        sut = SignUpService(persistencePort, existsChecker)
    }

    Given("중복된 이메일이 없는 경우") {
        val command = Command(email = "test@gmail.com", password = "test-1234")

        every { persistencePort.save(any()) } just Runs
        every { existsChecker.existsByPrincipal(any()) } just Runs

        When("회원가입 요청을 한다면") {

            sut.command(command)

            Then("save 함수가 호출된다.") {
                verify { persistencePort.save(any()) }
            }
        }
    }

    Given("중복된 이메일이 있는 경우") {
        val command = Command(email = "test@gmail.com", password = "test-1234")

        every { existsChecker.existsByPrincipal(any()) }.throws(IllegalArgumentException())

        When("회원가입 요청을 한다면") {
            Then("예외가 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    sut.command(command)
                }
            }

        }
    }
})

