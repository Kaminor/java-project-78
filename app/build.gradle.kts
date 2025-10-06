plugins {
    id("java")
    checkstyle
    id("org.sonarqube") version "6.3.1.5724"
    jacoco
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.3")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
}

sonar {
    properties {
        property("sonar.projectKey", "Kaminor_java-project-78")
        property("sonar.organization", "kaminor")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}