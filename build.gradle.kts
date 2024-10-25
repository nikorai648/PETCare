// build.gradle.kts (Project: PETCare)
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.google.services.jon) apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
