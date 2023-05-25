package kr.puppy.vote.auth.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldNotBe

class AuthenticationTests : DescribeSpec({
    describe("Authentication") {
        val sut = Authentication(principal = "test-1234", _credential = "1234")
        context("Authentication을 생성하면") {
            it("패스워드는 암호화된다.") {
                sut.shouldNotBe("1234")
            }
        }

        context("동일한 패스워드를 입력하면") {
            it("일차한다.") {
                sut.verify("1234").shouldBeTrue()
            }
        }

        context("잘못된 패스워드를 입력하면") {
            it("False가 리턴된다.") {
                sut.verify("12345").shouldBeFalse()
            }
        }
    }
})
