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
    implementation(Dependencies.UIComponents.appCompat)
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
    implementation(Dependencies.Lifecycle.liveData)

    // Navigation
    implementation(Dependencies.Navigation.fragment)
    implementation(Dependencies.Navigation.ui)

    // Retrofit
    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.converterGson)

    // OkHttpClient
    implementation(Dependencies.OkHttp.loggingInterceptor)
    implementation(Dependencies.OkHttp.okHttp)
    implementation(Dependencies.OkHttp.bom)

    // Hilt
    implementation(Dependencies.Hilt.android)
    kapt(Dependencies.Hilt.compiler)

    // Legacy Support
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    // Glide
    implementation(Dependencies.Glide.glide)


    // SplashScreen
    implementation(Dependencies.SplashScreen.splashScreen)

    // Paging
    implementation(Dependencies.Paging.runtime)

}