object Versions {
    const val AGP = "7.2.2"
    const val kotlin = "1.7.10"
    const val hilt = "2.44"
    const val androidCore = "1.7.0"
    const val appcompat = "1.5.1"
    const val constraint = "2.1.4"
    const val junit = "4.13.2"
    const val extJunit = "1.1.5"
    const val espresso = "3.5.1"
    const val room = "2.5.0"
    const val navGraph = "2.5.3"
    const val lifecycle = "2.5.1"
    const val viewBindingPropertyDelegate = "1.5.8"
    const val fragment = "1.5.5"
}

object Deps {

    object UI {
        const val androidCore = "androidx.core:core-ktx:${Versions.androidCore}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val material ="com.google.android.material:material:${Versions.androidCore}"
        const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
        const val junit = "junit:junit:${Versions.junit}"
        const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    }

    object Room {
        const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
        const val room = "androidx.room:room-ktx:${Versions.room}"
    }

    object NavGraph {
        const val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navGraph}"
        const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navGraph}"
    }

    object LifeCycle {
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        const val lfRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

    }

    object Dagger {
        const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    }

    object ViewBindingDelegateProperty {
        const val viewBindingPropertyDelegate = "com.github.kirich1409:viewbindingpropertydelegate-noreflection:${Versions.viewBindingPropertyDelegate}"
    }

}

object Plugins {

    object AGP {
        const val application = "com.android.application"
        const val library = "com.android.library"
    }

    object Kotlin {
        const val android = "org.jetbrains.kotlin.android"
        const val kapt = "kotlin-kapt"
    }

    object DaggerHilt {
        const val hilt = "com.google.dagger.hilt.android"
    }

}


