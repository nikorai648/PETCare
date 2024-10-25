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
    implementation(libs.appcompat) // Ajuste de dependencia appcompat
    implementation(libs.material) // Ajuste de dependencia material
    implementation(libs.activity.v193) // Ajuste de dependencia activity
    implementation(libs.constraintlayout) // Ajuste de dependencia constraintlayout
    implementation(libs.navigation.fragment.ktx) // Ajuste de dependencia navigation.fragment
    implementation(libs.navigation.ui.ktx) // Ajuste de dependencia navigation.ui

    // Importar el Firebase BoM
    implementation(libs.firebase.bom)

    // Añadir las dependencias de Firebase que quieras usar
    implementation(libs.google.firebase.database)
    implementation(libs.google.firebase.auth)
}
