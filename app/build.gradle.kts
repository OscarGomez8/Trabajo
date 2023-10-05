plugins {
}

android {
    namespace = "com.example.tareapm01_ejercicio1_oscaryairgomez"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.tareapm01_ejercicio1_oscaryairgomez"
        minSdk = 24
        targetSdk = 33
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
}

dependencies {

}