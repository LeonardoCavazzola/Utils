plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.slf4j:slf4j-api:2.0.0")
    implementation("org.apache.httpcomponents.core5:httpcore5:5.1.4")
    implementation("jakarta.servlet:jakarta.servlet-api:6.0.0")
    implementation("io.jsonwebtoken:jjwt-api:0.11.5")
    implementation("io.jsonwebtoken:jjwt-impl:0.11.5")
    implementation("io.jsonwebtoken:jjwt-jackson:0.11.5")
    implementation("org.apache.commons:commons-math3:3.6.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
