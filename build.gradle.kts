// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.6.0")
        classpath("com.google.gms:google-services:4.3.15") // Google services plugin
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

// Definir la tarea clean correctamente
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
