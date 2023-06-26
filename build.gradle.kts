import org.gradle.jvm.tasks.Jar
import java.net.URI
import org.jetbrains.dokka.gradle.DokkaTask
import java.net.URL

plugins {
    kotlin("jvm") version "1.8.20"
    id("java-library")
    id("maven-publish")
    id("signing")
    id("org.jetbrains.dokka") version "1.8.20"
}

val versionProject = "1.0.1"
val group = "dev.kaytea"
val jvmTargetCompatibility = 11

repositories {
    mavenCentral()
    maven { url = URI("https://oss.sonatype.org/content/repositories/snapshots/") }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.4.31")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    platform("org.jetbrains.kotlin:kotlin-bom")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(jvmTargetCompatibility))
    withSourcesJar()
    withJavadocJar()
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = group
            artifactId = project.name
            version = versionProject

            from(components.findByName("java"))
            pom {
                name            .set("CompxCLib")
                description     .set("Complex Complete Library is a feature rich complex numbers library for Kotlin and Java")
                url             .set("https://github.com/KatieUmbra/compxclib")
                inceptionYear   .set("2023")

                licenses {
                    license {
                        name    .set("MIT License")
                        url     .set("https://github.com/KatieUmbra/compxclib/blob/main/LICENSE")
                    }
                }

                developers {
                    developer {
                        id      .set("Kanwi")
                        name    .set("Katherine Chesterfield")
                        email   .set("katherine@kaytea.dev")
                    }
                }

                scm {
                    connection          .set("scm:git:git:github.com/KatieUmbra/compxclib.git")
                    developerConnection .set("scm:git:ssh://github.com/KatieUmbra/compxclib.git")
                    url                 .set("https://github.com/KatieUmbra/compxclib")
                }
            }
            repositories {
                maven {
                    name = "OSSRH"
                    url = URI("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
                    credentials {
                        username = project.properties["ossrhUsername"].toString()
                        password = project.properties["ossrhPassword"].toString()
                    }
                }
            }
        }
    }
}

signing {
    sign(publishing.publications.findByName("mavenJava"))
}

tasks.named<Jar>("javadocJar") {
    from(tasks.named("dokkaJavadoc"))
}

kotlin {
    jvmToolchain(jvmTargetCompatibility)
}

tasks.withType<DokkaTask>().configureEach {
    moduleName                  .set(project.name)
    moduleVersion               .set(project.version.toString())
    outputDirectory             .set(file("build/dokka/$name"))
    failOnWarning               .set(false)
    suppressObviousFunctions    .set(false)
    suppressInheritedMembers    .set(false)
    offlineMode                 .set(false)

    dokkaSourceSets.configureEach {
        displayName             .set(name)
        suppress                .set(displayName.get() != "main")
        reportUndocumented      .set(true)
        skipEmptyPackages       .set(true)
        skipDeprecated          .set(true)
        suppressGeneratedFiles  .set(true)
        jdkVersion              .set(8)
        languageVersion         .set("11")
        apiVersion              .set("11")
        noStdlibLink.           set(false)
        noJdkLink               .set(false)
        noAndroidSdkLink        .set(false)
        includes    .from(project.files(), "Module.md")
        sourceRoots .from(file("src/main/kotlin"))
        samples     .from(project.files(), "src/samples/kotlin/Basic.kt")
        sourceLink {
            localDirectory      .set(file("src/main/kotlin"))
            remoteUrl           .set(URL("https://github.com/KatieUmbra/compxclib/tree/main/src/main/kotlin"))
            remoteLineSuffix    .set("#L")
        }
    }
}