dependencies {
    implementation(project(":puppy-vote-domain"))

    runtimeOnly("com.mysql:mysql-connector-j")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}