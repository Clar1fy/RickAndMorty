plugins {
    // Application
    id("com.android.application")

    // Kotlin
    kotlin("android")

    // Kapt
    kotlin("kapt")

    // Navigation SafeArgs
    id(Dependencies.Navigation.safeArgsPlugin)

    // Hilt
    id(Dependencies.Hilt.plugin)

    // Firebase
//    id(Dependencies.Firebase.googleServices)
}

android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = "com.timplifier.rickandmorty"
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    //ViewBinding
    buildFeatures.viewBinding = true
}

dependencies {

    // UI Components
    implementation(Dependencies.UIComponents.material)
    implementation(Dependencies.UIComponents.constraintLayout)
    implementation(Dependencies.UIComponents.viewBindingPropertyDelegate)

    // Core
    implementation(Dependencies.Core.core)

    // Activity
    implementation(Dependencies.Activity.activity)

    // Fragment
    implementation(Dependencies.Fragment.fragment)

    // Lifecycle
    implementation(Dependencies.Lifecycle.runtime)
    implementation(Dependencies.Lifecycle.viewModel)

    // Navigation
    implementation(Dependencies.Navigation.fragment)
    implementation(Dependencies.Navigation.ui)

    // Retrofit
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.converterGson)

    // Hilt
    implementation(Dependencies.Hilt.android)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    kapt(Dependencies.Hilt.compiler)

    //Firebase
//    implementation(Dependencies.Firebase.version)
//    implementation(Dependencies.Firebase.analytics)
//    implementation (Dependencies.Firebase.platform)
//    implementation(Dependencies.Firebase.auth)

    // SplashScreen
    implementation(Dependencies.SplashScreen.splashScreen)

}