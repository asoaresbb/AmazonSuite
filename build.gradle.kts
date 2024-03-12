import io.qameta.allure.gradle.base.AllureExtension

plugins {
    id("org.jetbrains.kotlin.jvm") version "2.0.0-Beta4"
    id("io.qameta.allure") version "2.11.2"
    id("io.qameta.allure-report") version "2.11.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.1")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.18.1")
    testImplementation("io.qameta.allure:allure-junit5:2.25.0")
    implementation("com.luissoares:selenium-testing-library:4.1.3")
}

tasks.test {
    useJUnitPlatform()
}

configure<AllureExtension> {
    adapter {
        autoconfigure.set(true)
        aspectjWeaver.set(true)
    }
}

kotlin {
    jvmToolchain(17)
}