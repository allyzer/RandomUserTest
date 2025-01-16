plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.dagger.hilt)
    id("kotlin-kapt")
    id("com.google.devtools.ksp")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "com.allyzer.randomusertest"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.allyzer.randomusertest"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.allyzer.randomusertest.HiltTestRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
            merges += "META-INF/LICENSE.md"
            merges += "META-INF/LICENSE-notice.md"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //hilt
    implementation(libs.dagger.hilt)
    kapt (libs.dagger.hilt.compiler)
    implementation (libs.hilt.navigation.compose)

    //compose dependencies
    implementation (libs.androidx.navigation.compose)
    implementation (libs.androidx.material.icons.extended)
    implementation (libs.androidx.lifecycle.viewmodel)

    //coroutines
    implementation (libs.coroutine.android)

    //serialization
    implementation (libs.serialization.android)

    //room
    implementation (libs.room.runtime)
    implementation (libs.room.ktx)
    ksp (libs.room.compiler)

    //retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.okhttp)
    implementation(libs.okhttp.interceptor)

    //Image Loading
    implementation(libs.coil)
    implementation(libs.coil.network)

    //Local unit tests
    testImplementation(libs.junit)
    testImplementation(libs.arch.core)
    testImplementation(libs.test.core)
    testImplementation(libs.test.coroutine)
    testImplementation(libs.google.truth)
    testImplementation(libs.okhttp.mock)
    testImplementation(libs.io.mockk)
    debugImplementation(libs.compose.ui.test)

    // Instrumentation tests
    androidTestImplementation(libs.hilt.testing)
    kaptAndroidTest(libs.dagger.hilt.compiler)
    androidTestImplementation(libs.junit)
    androidTestImplementation(libs.test.ktx)
    androidTestImplementation(libs.test.runner)
    androidTestImplementation(libs.arch.core)
    androidTestImplementation(libs.test.coroutine)
    androidTestImplementation(libs.google.truth)
    androidTestImplementation(libs.okhttp.mock)
}

kapt {
    correctErrorTypes = true
}