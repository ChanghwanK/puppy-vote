package kr.puppy.vote

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PuppyVoteApplication

fun main(args: Array<String>) {
    runApplication<PuppyVoteApplication>(*args)
}