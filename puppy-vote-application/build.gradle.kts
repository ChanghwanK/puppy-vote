dependencies {
    implementation(project(":puppy-vote-domain"))
    implementation(project(":puppy-vote-infrastructure:persistence-database"))

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}