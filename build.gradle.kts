plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.google.services) apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
