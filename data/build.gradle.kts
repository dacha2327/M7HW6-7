import Plugins.Kotlin.kapt

plugins {
    id (Plugins.AGP.library)
    id (Plugins.Kotlin.kapt)
    id (Plugins.Kotlin.android)
}

android {
    namespace = "com.example.m7hw1"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility =  JavaVersion.VERSION_1_8
        targetCompatibility =  JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":domain"))

    implementation (Deps.UI.androidCore)
    testImplementation (Deps.UI.junit)
    androidTestImplementation (Deps.UI.extJunit)

    //Room
    implementation(Deps.Room.room)
    implementation(Deps.Room.roomRuntime)
    kapt(Deps.Room.roomCompiler)

    //dagger
    implementation(Deps.Javax.inject)

    //Coroutine
    implementation(Deps.Coroutines.android)


}