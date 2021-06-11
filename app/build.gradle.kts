plugins {
    id(DependencyConfig.Plugin.APPLICATION)
    id(DependencyConfig.Plugin.KOTLIN_ANDROID)
    id(DependencyConfig.Plugin.KOTLIN_KAPT)
    id(DependencyConfig.Plugin.ANDROID_HILT)
    id("scabbard.gradle") version "0.4.0"
}

subprojects {
    apply {
        from("variants.gradle.kts")
    }
}

scabbard {
    enabled = true
}

android {
    compileSdk = Version.AppConfig.Base.COMPILE_SDK

    defaultConfig {
        applicationId = Version.AppConfig.Base.APP_ID
        minSdk = Version.AppConfig.Base.MIN_SDK
        targetSdk = Version.AppConfig.Base.TARGET_SDK
        versionCode = Version.AppConfig.Base.VERSION_CODE
        versionName = Version.AppConfig.Base.VERSION_NAME

        testInstrumentationRunner = Version.AppConfig.Base.TEST_RUNNER
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Version.AppConfig.Android.COMPOSE
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(DependencyManager.appLibraries)
    kapt(DependencyManager.compilerLibraries)
    testImplementation(DependencyManager.testLibraries)
    androidTestImplementation(DependencyManager.androidTestLibraries)
}