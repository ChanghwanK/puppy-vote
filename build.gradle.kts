import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.8"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.7.22"
    kotlin("plugin.spring") version "1.7.22"
    kotlin("plugin.jpa") version "1.6.21"
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
}

java.sourceCompatibility = JavaVersion.VERSION_17

allprojects {
    group = "kr.puppy.vote"
    version = "0.0.1-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "kotlin")
    apply(plugin = "kotlin-spring")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "kotlin-kapt")
    apply(plugin= "kotlin-jpa")

    dependencies {
        // jwt
        implementation("io.jsonwebtoken:jjwt-api:0.11.5")
        runtimeOnly("io.jsonwebtoken:jjwt-impl:0.11.5")
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        testImplementation("org.springframework.boot:spring-boot-starter-test") {
            exclude(module = "mockito-core")
            exclude(group = "org.mockito")
        }
        testImplementation("com.ninja-squad:springmockk:4.0.2")
        testImplementation("io.kotest:kotest-runner-junit5:5.4.2")
        testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.2")
    }

    dependencyManagement {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }
}
