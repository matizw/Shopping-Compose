import dependencies.MyDependencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

@Suppress("UnstableApiUsage")
android {
    namespace = "id.trainingdemo.core"
    compileSdk = Versions.compile_sdk

    defaultConfig {
        minSdk = Versions.min_sdk
        targetSdk = Versions.target_sdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose_compiler
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    tasks.withType().configureEach {
        kotlinOptions.freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
    }
}

dependencies {
 
    api(MyDependencies.core_ktx)
    api(MyDependencies.lifecycle_ktx)
 
    api(MyDependencies.material_compose)
    api(MyDependencies.activity_compose)
    api(MyDependencies.ui_compose)
    api(MyDependencies.ui_tooling_preview)
    api(MyDependencies.navigation_compose)
 
    testImplementation(MyDependencies.junit)
    androidTestImplementation(MyDependencies.test_ext_junit)
    androidTestImplementation(MyDependencies.espresso_core)
    androidTestImplementation(MyDependencies.junit_compose)
    debugImplementation(MyDependencies.ui_tooling)
    debugImplementation(MyDependencies.ui_test_manifest)
 
    testImplementation(MyDependencies.mockito_kotlin)
 
    testImplementation(MyDependencies.coroutines_test)
 
    api(MyDependencies.retrofit)
    api(MyDependencies.retrofit2_converter_gson)
    api(MyDependencies.retrofit2_adapter_rxjava2)
    api(MyDependencies.okhttp3)
 
    api(MyDependencies.coil)
 
    implementation(MyDependencies.hilt_android)
    kapt(MyDependencies.hilt_android_compiler)
    api(MyDependencies.hilt_navigation_compose) {
        exclude("androidx.lifecycle", "lifecycle-viewmodel-ktx")
    }
 
    api(MyDependencies.room)
    kapt(MyDependencies.room_kapt)
    api(MyDependencies.room_ktx)
 
    api(MyDependencies.accompanist_pager)
    api(MyDependencies.accompanist_pager_indicator)
 
    api(MyDependencies.accompanist_systemuicontroller)
}