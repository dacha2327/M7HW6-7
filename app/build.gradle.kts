plugins {
    id (Plugins.AGP.application)
    id (Plugins.Kotlin.android)
    id (Plugins.Kotlin.kapt)
    id(Plugins.DaggerHilt.hilt)
}

android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.example.m7hw1"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = 1
        versionName  = "1.0"

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

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation (Deps.UI.androidCore)
    implementation (Deps.UI.appcompat)
    implementation (Deps.UI.material)
    implementation (Deps.UI.constraint)
    testImplementation (Deps.UI.junit)
    implementation(Deps.UI.fragment)
    androidTestImplementation (Deps.UI.extJunit)
    androidTestImplementation (Deps.UI.espresso)

    //Nav_Graph
    implementation(Deps.NavGraph.fragment)
    implementation (Deps.NavGraph.ui)

    //Room
    implementation(Deps.Room.room)
    implementation(Deps.Room.roomRuntime)
    kapt(Deps.Room.roomCompiler)

    //Lifecycle
    implementation(Deps.LifeCycle.viewModel)
    implementation(Deps.LifeCycle.lfRuntime)

     //dagger
    implementation(Deps.Dagger.hilt)
    kapt(Deps.Dagger.compiler)

    //ViewBinding
    implementation(Deps.ViewBindingDelegateProperty.viewBindingPropertyDelegate)

}