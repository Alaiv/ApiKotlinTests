import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.23"
    id("io.qameta.allure") version "2.8.1"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(17)
}


val junitVersion = "5.9.0"
val restAssuredVersion = "5.1.1"
val jacksonVersion = "2.13.3"
val allureVersion = "2.19.0"

dependencies {

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")

    implementation("io.rest-assured:rest-assured:$restAssuredVersion")
    implementation("io.rest-assured:json-path:$restAssuredVersion")
    testImplementation("io.rest-assured:kotlin-extensions:$restAssuredVersion")

    implementation("com.fasterxml.jackson.core:jackson-annotations:$jacksonVersion")
    implementation("com.fasterxml.jackson.core:jackson-core:$jacksonVersion")
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")

    implementation("io.qameta.allure:allure-rest-assured:$allureVersion")
    testImplementation("io.qameta.allure:allure-junit5:$allureVersion")

    testImplementation("org.slf4j:slf4j-simple:2.0.0")
    implementation("com.typesafe:config:1.4.2")

    implementation("org.assertj:assertj-core:3.23.1")

}

tasks.test {
    allureConfig
    useJUnitPlatform()
    systemProperties["PORT"] = properties["port"]
    systemProperties["URL"] = properties["url"]
}

val allureConfig = allure {
    configuration = "testImplementation"
    version = allureVersion
    autoconfigure = true
    aspectjweaver = true
    clean = true
    useJUnit5 {
        version = allureVersion
    }
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "17"
}