object Version {

    object Project {
        const val GRADLE_TOOLS = "7.1.0-alpha02"
        const val KOTLIN_GRADLE = "1.5.10"
        const val DAGGER_HILT = "2.36"
    }

    object AppConfig {
        object Base {
            const val APP_ID = "com.darklabs.basecompose"
            const val COMPILE_SDK = 30
            const val MIN_SDK = 21
            const val TARGET_SDK = 30
            const val VERSION_CODE = 1
            const val VERSION_NAME = "1.0.0"
            const val TEST_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
        }

        object Android {
            const val COMPOSE = "1.0.0-beta08"
            const val ACTIVITY_COMPOSE = "1.3.0-beta01"
            const val CORE = "1.5.0"
            const val APP_COMPAT = "1.3.0"
            const val LIFECYCLE_KTX = "2.3.1"
            const val MATERIAL = "1.3.0"
            const val COROUTINES = "1.5.0"
            const val RETROFIT = "2.9.0"
            const val LOGGING = "5.0.0-alpha.2"
            const val KOTLINX_SERIALIZATION = "0.8.0"
            const val KOTLINX_JSON = "1.2.1"
        }


        object Testing {
            const val JUNIT = "4.+"
            const val ANDROID_JUNIT = "1.1.2"
            const val ESPRESSO = "3.3.0"
        }
    }
}