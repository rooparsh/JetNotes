object DependencyConfig {

    object Plugin {
        const val APPLICATION = "com.android.application"
        const val ANDROID_LIBRARY_PLUGIN = "com.android.library"
        const val KOTLIN_ANDROID = "kotlin-android"
        const val KOTLIN_KAPT = "kotlin-kapt"
        const val ANDROID_HILT = "dagger.hilt.android.plugin"
        const val KOTLINX_SERIALIZATION = "kotlinx-serialization"
        const val KOTLIN_PARCELIZE = "kotlin-parcelize"
    }

    object Compose {
        private const val UI = "androidx.compose.ui:ui:${Version.AppConfig.Android.COMPOSE}"
        private const val MATERIAL =
            "androidx.compose.material:material:${Version.AppConfig.Android.COMPOSE}"
        private const val TOOLING =
            "androidx.compose.ui:ui-tooling:${Version.AppConfig.Android.COMPOSE}"
        private const val ACTIVITY =
            "androidx.activity:activity-compose:${Version.AppConfig.Android.ACTIVITY_COMPOSE}"

        val list = arrayListOf<String>().apply {
            add(UI)
            add(MATERIAL)
            add(TOOLING)
            add(ACTIVITY)
        }
    }

    object Android {
        private const val CORE = "androidx.core:core-ktx:${Version.AppConfig.Android.CORE}"
        private const val APP_COMPAT =
            "androidx.appcompat:appcompat:${Version.AppConfig.Android.APP_COMPAT}"
        private const val LIFE_CYCLE_KTX =
            "androidx.lifecycle:lifecycle-runtime-ktx:${Version.AppConfig.Android.LIFECYCLE_KTX}"
        private const val VIEW_MODEL =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.AppConfig.Android.LIFECYCLE_KTX}"

        val list = arrayListOf<String>().apply {
            add(CORE)
            add(APP_COMPAT)
            add(LIFE_CYCLE_KTX)
            add(VIEW_MODEL)
        }
    }

    object Google {
        private const val MATERIAL =
            "com.google.android.material:material:${Version.AppConfig.Android.MATERIAL}"

        object Di {
            private const val HILT = "com.google.dagger:hilt-android:${Version.Project.DAGGER_HILT}"
            private const val HILT_COMPILER =
                "com.google.dagger:hilt-android-compiler:${Version.Project.DAGGER_HILT}"

            val list = arrayListOf<String>().apply {
                add(HILT)
            }

            val compilerList = arrayListOf<String>().apply {
                add(HILT_COMPILER)
            }
        }

        val list = arrayListOf<String>().apply {
            add(MATERIAL)
        }
    }

    object Async {
        private const val COROUTINES =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.AppConfig.Android.COROUTINES}"
        private const val COROUTINES_ANDROID =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.AppConfig.Android.COROUTINES}"


        val list = arrayListOf<String>().apply {
            add(COROUTINES)
            add(COROUTINES_ANDROID)
        }
    }

    object Networking {
        private const val RETROFIT =
            "com.squareup.retrofit2:retrofit:${Version.AppConfig.Android.RETROFIT}"
        private const val LOGGING =
            "com.squareup.okhttp3:logging-interceptor:${Version.AppConfig.Android.LOGGING}"
        private const val KOTLIN_SERIALIZATION =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter" +
                    ":${Version.AppConfig.Android.KOTLINX_SERIALIZATION}"
        private const val KOTLINX_JSON =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:${Version.AppConfig.Android.KOTLINX_JSON}"

        val list = arrayListOf<String>().apply {
            add(RETROFIT)
            add(LOGGING)
            add(KOTLIN_SERIALIZATION)
            add(KOTLINX_JSON)
        }
    }

    object Testing {

        object Functional {
            private const val JUNIT = "junit:junit:${Version.AppConfig.Testing.JUNIT}"

            val list = arrayListOf<String>().apply {
                add(JUNIT)
            }
        }

        object Ui {
            private const val JUNIT =
                "androidx.test.ext:junit:${Version.AppConfig.Testing.ANDROID_JUNIT}"
            private const val ESPRESSO =
                "androidx.test.espresso:espresso-core:${Version.AppConfig.Testing.ESPRESSO}"
            private const val COMPOSE =
                "androidx.compose.ui:ui-test-junit4:${Version.AppConfig.Android.COMPOSE}"

            val list = arrayListOf<String>().apply {
                add(JUNIT)
                add(ESPRESSO)
                add(COMPOSE)
            }
        }

    }
}