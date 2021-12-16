plugins {
    kotlin("multiplatform") version "1.6.10"
    `maven-publish`
}

group = "net.henryhc.redstone"
version = parent!!.version

repositories {
    mavenCentral()
}

kotlin {
    /* Targets configuration omitted. 
    *  To find out how to configure the targets, please follow the link:
    *  https://kotlinlang.org/docs/reference/building-mpp-with-gradle.html#setting-up-targets */


    jvm {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
        testRuns {
            @Suppress("UNUSED_VARIABLE")
            val test by getting {
                executionTask {
                    useJUnitPlatform()
                }
            }
        }
    }

    @Suppress("UNUSED_VARIABLE")
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val jvmMain by getting
        val jvmTest by getting
    }
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/henryhchchc/redstone")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
}
