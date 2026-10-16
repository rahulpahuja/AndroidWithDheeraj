plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.rp.livedataapp"
    compileSdk {
        version = release(37)
    }

    defaultConfig {
        applicationId = "com.rp.livedataapp"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            optimization {
                enable = true
                packageScope = setOf("androidx.**", "kotlin.**", "kotlinx.**")
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    // Standard LiveData and ViewModel dependencies
    implementation("androidx.lifecycle:lifecycle-livedata:2.8.6")
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.8.6")
    // Core coroutines library for common functionality (Flow, builders, etc.)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.11.0")
    implementation("androidx.datastore:datastore-preferences:1.1.2")
    // Android-specific support (provides Dispatchers.Main and Android main thread integration)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.11.0")
    // Optional: LiveData KTX (highly recommended for Kotlin users)
    // Provides 'liveData' coroutine builder functions and extensions
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.6")
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(libs.androidx.junit)
}