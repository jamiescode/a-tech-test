plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
    id("kotlin-parcelize")
    alias(libs.plugins.kotlinter)
    alias(libs.plugins.detekt)
    id("androidx.navigation.safeargs")
}

android {
    namespace = "com.a.technicaltest"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.a.technicaltest"
        minSdk = 29
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }


    kotlinOptions {
        jvmTarget = "17"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
    }

    buildFeatures {
        dataBinding = true
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)
    implementation(libs.androidx.navigation.compose)
    testImplementation(libs.coroutines.test)
    testImplementation(libs.junit)

    implementation(libs.activity.ktx)
    implementation(libs.fragment.ktx)
    implementation(libs.material)
    implementation(libs.nav.fragment.ktx)
    implementation(libs.nav.ui.ktx)
    implementation(libs.lifecycle.livedata.ktx)
    testImplementation(libs.core.testing)
    implementation(libs.gson)
    androidTestImplementation(libs.core.testing)
    testImplementation(libs.mockk)
    testImplementation(libs.mockk.android)
    testImplementation(libs.assertk)


    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.9.3")
    implementation(platform("androidx.compose:compose-bom:2024.04.01"))
    implementation("androidx.compose.ui:ui:1.6.0")
    implementation("androidx.compose.ui:ui-graphics:1.6.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.0")
    implementation ("androidx.navigation:navigation-fragment-compose:2.8.3")
    implementation(libs.androidx.material3)
    implementation(libs.androidx.ui.graphics.android)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(kotlin("script-runtime"))
}
