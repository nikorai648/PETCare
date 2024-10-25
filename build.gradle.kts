// build.gradle.kts (Project: PETCare)

plugins {
    // No necesitas importar com.android.builder.files.classpathToRelativeFileSet aquí.
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.google.services) apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

