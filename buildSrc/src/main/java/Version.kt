object Version {

    object Project {
        const val GRADLE_TOOLS = "7.1.0-alpha13"
        const val KOTLIN_GRADLE = "1.5.21"
        const val DAGGER_HILT = "2.38.1"
    }

    object AppConfig {
        object Base {
            const val APP_ID = "com.darklabs.jetnotes"
            const val COMPILE_SDK = 30
            const val MIN_SDK = 21
            const val TARGET_SDK = 30
            const val VERSION_CODE = 1
            const val VERSION_NAME = "1.0.0"
            const val TEST_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
        }

        object Android {
            const val COMPOSE = "1.0.3"
            const val ACTIVITY_COMPOSE = "1.3.0"
            const val CORE = "1.5.0"
            const val APP_COMPAT = "1.3.0"
            const val ANDROIDX_HILT_COMPILER = "1.0.0"
            const val LIFECYCLE_KTX = "2.3.1"
            const val NAVIGATION_COMPOSE = "2.4.0-alpha06"
            const val HILT_NAVIGATION_COMPOSE = "1.0.0-alpha03"
            const val MATERIAL = "1.5.0-alpha01"
            const val COROUTINES = "1.5.1"
            const val RETROFIT = "2.9.0"
            const val LOGGING = "5.0.0-alpha.2"
            const val KOTLINX_SERIALIZATION = "0.8.0"
            const val KOTLINX_JSON = "1.2.2"
            const val ACCOMPANIST = "0.16.0"
            const val COIL = "1.3.2"
        }

        object Multiplatform {
            const val KTOR = "1.6.1"
        }


        object Testing {
            const val JUNIT = "4.+"
            const val ANDROID_JUNIT = "1.1.2"
            const val ESPRESSO = "3.3.0"
        }
    }
}