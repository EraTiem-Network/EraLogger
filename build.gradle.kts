import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.20"
    `maven-publish`
}

group = "net.eratiem.log"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = project.group.toString()
            version = project.version.toString()
            artifactId = project.name

            from(components["java"])
        }
    }
    repositories {
        maven {
            url = uri("https://artifactory.hingel.tech/artifactory/eratiem"
                        + (if (project.version.toString().contains("SNAPSHOT"))
                            "-snapshot" else ""))
            credentials {
                username = System.getenv("MAVEN_USR") ?: "admin"
                password = System.getenv("MAVEN_PSW") ?: ""
            }
        }
    }
}

java {
    withJavadocJar()
    withSourcesJar()
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}