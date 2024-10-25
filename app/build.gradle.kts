plugins {
    id("com.android.application")
    // Añade el plugin de servicios de Google
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.petcare"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.petcare"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)

    // Importa el BoM de Firebase
    implementation(platform("com.google.firebase:firebase-bom:33.5.1"))

    // Añade las dependencias de los productos de Firebase que deseas usar
    // Ejemplo:
    // implementation("com.google.firebase:firebase-database")
    // implementation("com.google.firebase:firebase-auth")
}
