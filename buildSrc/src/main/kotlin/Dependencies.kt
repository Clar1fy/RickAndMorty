object Dependencies {

    object AGP {
        const val version = "7.1.3"
        const val application = "com.android.application"
        const val library = "com.android.library"
    }

    object Kotlin {

        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0"

        object KSP {
            const val ksp = "com.google.devtools.ksp"
            const val version = "1.6.10-1.0.4"
        }
    }

    // App
    object UIComponents {
        const val material = "com.google.android.material:material:1.5.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.3"
        const val viewBindingPropertyDelegate =
            "com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.6"
        const val appCompat = "androidx.appcompat:appcompat:1.4.1"
    }

    object Core {
        private const val version = "1.7.0"

        const val core = "androidx.core:core-ktx:$version"
    }

    object Activity {
        private const val version = "1.4.0"

        const val activity = "androidx.activity:activity-ktx:$version"
    }

    object Fragment {
        private const val version = "1.4.1"

        const val fragment = "androidx.fragment:fragment-ktx:$version"
    }

    object Lifecycle {
        private const val version = "2.4.1"

        // | for Lifecycles only (without ViewModel or LiveData)
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"

        // | for ViewModel
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
    }

    object Navigation {
        const val version = "2.4.1"

        const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
        const val ui = "androidx.navigation:navigation-ui-ktx:$version"
        const val safeArgsPlugin = "androidx.navigation.safeargs.kotlin"
    }

    object Hilt {
        const val version = "2.41"

        const val android = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-compiler:$version"
        const val plugin = "com.google.dagger.hilt.android"
    }

    // Data
    object Retrofit {
        private const val version = "2.9.0"

        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val converterGson = "com.squareup.retrofit2:converter-gson:$version"
    }

    object OkHttp {
        private const val version = "5.0.0-alpha.5"

        const val bom = "com.squareup.okhttp3:okhttp-bom:$version"
        const val okHttp = "com.squareup.okhttp3:okhttp"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor"
    }

    object Room {
        private const val version = "2.4.2"

        const val runtime = "androidx.room:room-runtime:$version"
        const val compiler = "androidx.room:room-compiler:$version"

        // | optional - Kotlin Extensions and Coroutines support for Room
        const val supportKotlinExtensionsAndCoroutines = "androidx.room:room-ktx:$version"
    }

    object Paging {
        private const val version = "3.1.1"

        const val runtime = "androidx.paging:paging-runtime-ktx:$version"
    }

    object Firebase {
        const val servicesVersion = "4.3.10"
        const val version = "com.google.firebase:firebase-firestore-ktx"
        const val analytics = "com.google.firebase:firebase-analytics-ktx"
        const val platform = "com.google.firebase:firebase-bom:29.2.0"
        const val auth = "com.google.firebase:firebase-auth-ktx"
        const val googleServices = "com.google.gms.google-services"
        const val services = "com.google.gms:google-services"
    }

    object SplashScreen {
        const val splashScreen = "androidx.core:core-splashscreen:1.0.0-beta01"
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:4.13.0"
    }

    object Koin {
        private const val version = "3.2.0-beta-1"
        const val koinAndroid = "io.insert-koin:koin-android:$version"

    }
}