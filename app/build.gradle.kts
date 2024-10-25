// Aplicar los plugins correctos
plugins {
    id("com.android.application")
    id("com.google.gms.google-services") // Asegúrate de que esta línea esté presente para Firebase
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
    implementation("androidx.appcompat:appcompat:1.6.1") // Versión específica de appcompat
    implementation("com.google.android.material:material:1.8.0") // Versión específica de material
    implementation("androidx.activity:activity-ktx:1.7.2") // Versión específica de activity-ktx
    implementation("androidx.constraintlayout:constraintlayout:2.1.4") // Versión específica de constraintlayout
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3") // Versión específica de navigation-fragment
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3") // Versión específica de navigation-ui

    // BoM de Firebase para gestionar versiones automáticamente
    implementation(platform("com.google.firebase:firebase-bom:33.5.1"))

    // Dependencias de Firebase
    implementation("com.google.firebase:firebase-database")
    implementation("com.google.firebase:firebase-auth")
}