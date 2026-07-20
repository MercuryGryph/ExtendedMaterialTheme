plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.kotlin.compose)
}

group = "cn.mercury9.extendedmaterialtheme.example"
version = "unspecified"

kotlin {
    jvm()

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.ui)
            implementation(libs.compose.material3)

            implementation(project(":library"))
        }

        jvmMain.dependencies {
            implementation(compose.desktop.currentOs) {
                exclude(group = "org.jetbrains.compose.material")
            }
        }
    }
}

compose {
    desktop {
        application {
            mainClass = "cn.mercury9.extendedmaterialtheme.example.MainKt"
        }
    }
}
