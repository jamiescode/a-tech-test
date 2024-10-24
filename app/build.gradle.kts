plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlinter)
    alias(libs.plugins.detekt)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.safe.args)
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

    packaging {
        resources {
            excludes += "META-INF/**"
        }
    }
}

dependencies {
    implementation(libs.bundles.core)
    implementation(libs.bundles.nav)
    implementation(libs.bundles.coroutines)
    implementation(libs.bundles.lifecycle)
    implementation(libs.gson)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)

    testImplementation(project(":testutils"))
    testImplementation(platform(libs.junit5.bom))
    testImplementation(libs.bundles.test)
    androidTestImplementation(libs.bundles.uitest)
}
