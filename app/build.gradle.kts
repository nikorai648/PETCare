// build.gradle.kts (Module: app)
plugins {
    id("com.android.application")
    id("com.google.gms.google-services") // Aplica el plugin de Google Services
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
    implementation("androidx.appcompat:appcompat:1.6.1") // Ajusta según la versión que necesites
    implementation("com.google.android.material:material:1.9.0") // Ajusta según la versión que necesites
    implementation("androidx.activity:activity-ktx:1.7.2") // Ajusta según la versión que necesites
    implementation("androidx.constraintlayout:constraintlayout:2.1.4") // Ajusta según la versión que necesites
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.0") // Ajusta según la versión que necesites
    implementation("androidx.navigation:navigation-ui-ktx:2.7.0") // Ajusta según la versión que necesites
    testImplementation("junit:junit:4.13.2") // Ajusta según la versión que necesites
    androidTestImplementation("androidx.test.ext:junit:1.1.5") // Ajusta según la versión que necesites
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1") // Ajusta según la versión que necesites

    // Dependencias de Firebase
    implementation(platform("com.google.firebase:firebase-bom:32.0.0")) // Usa la última versión de BOM
    implementation("com.google.firebase:firebase-database")
    implementation("com.google.firebase:firebase-auth")
}
