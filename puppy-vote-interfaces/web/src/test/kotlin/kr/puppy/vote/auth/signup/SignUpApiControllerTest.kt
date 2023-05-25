package kr.puppy.vote.auth.signup

import com.fasterxml.jackson.databind.ObjectMapper
import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import kr.puppy.vote.auth.usecase.Command
import kr.puppy.vote.auth.usecase.SignUpUseCase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.filter.CharacterEncodingFilter

@ContextConfiguration(classes = [SignUpApiController::class])
@WebMvcTest
class SignUpApiControllerTest(
    var webApplicationContext: WebApplicationContext,

    @MockkBean
    var signUpUseCase: SignUpUseCase,

    @Autowired
    var mapper: ObjectMapper,
) : DescribeSpec({

    lateinit var mockMvc: MockMvc

    beforeEach {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
            .addFilter<DefaultMockMvcBuilder>(CharacterEncodingFilter("UTF-8", true))
            .alwaysDo<DefaultMockMvcBuilder>(MockMvcResultHandlers.print())
            .build()
    }

    describe("회원") {
        context("정상적인 회원가입 요청 Request 전송하면") {
            val request = SignUpRequestForm(email = "test@naver.com", password = "test-1234")
            every { signUpUseCase.command(Command(request.email, request.password)) } just Runs
            it("200이 반환된다.") {
                mockMvc.post("/api/v1/signup") {
                    contentType = MediaType.APPLICATION_JSON
                    content = mapper.writeValueAsString(request)
                    accept = MediaType.APPLICATION_JSON
                }.andExpect {
                    status { isOk() }
                }
            }
        }
    }
})
