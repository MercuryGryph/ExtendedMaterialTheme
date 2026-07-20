import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.android.kotlin.multiplatform.library)
    alias(libs.plugins.vanniktech.mavenPublish)
}

group = "cn.mercury9.extendedmaterialtheme"
val artifactId = "extendedmaterialtheme"
version = "1.0.0"

kotlin {
    jvm()
    androidLibrary {
        namespace = "${group}.${artifacts}"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        withJava() // enable java compilation support
        withHostTestBuilder {}.configure {}
        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }

        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }
    }
    iosArm64()
    iosSimulatorArm64()
    js(IR) {
        browser()
        nodejs()
    }
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        nodejs()
        d8()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.ui)
            implementation(libs.compose.material3)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

mavenPublishing {
    publishToMavenCentral()

    signAllPublications()

    coordinates(group.toString(), artifactId, version.toString())

    pom {
        name = "Extended MaterialTheme"
        description = "Some utils to help you use MaterialTheme more easily."
        inceptionYear = "2026"
        url = "https://github.com/MercuryGryph/ExtendedMaterialTheme"
        licenses {
            license {
                name = "Apache License, Version 2.0"
                url = "http://www.apache.org/licenses/"
            }
        }
        developers {
            developer {
                id = "MercuryGryph"
                name = "Mercury Gryph"
                url = "https://github.com/MercuryGryph"
            }
        }
        scm {
            url = "https://github.com/MercuryGryph/ExtendedMaterialTheme"
            connection = "scm:git:git://github.com/MercuryGryph/ExtendedMaterialTheme.git"
            developerConnection = "scm:git:ssh://git@github.com:MercuryGryph/ExtendedMaterialTheme.git"
        }
    }
}
