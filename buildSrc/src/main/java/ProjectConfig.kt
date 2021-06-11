object ProjectConfig {

    private const val GRADLE_TOOLS =
        "com.android.tools.build:gradle:${Version.Project.GRADLE_TOOLS}"
    private const val KOTLIN_GRADLE =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.Project.KOTLIN_GRADLE}"
    private const val DAGGER_HILT =
        "com.google.dagger:hilt-android-gradle-plugin:${Version.Project.DAGGER_HILT}"
    private const val KOTLINX_SERIALIZATION =
        "org.jetbrains.kotlin:kotlin-serialization:${Version.Project.KOTLIN_GRADLE}"



    val classPathList = arrayListOf<String>().apply {
        add(GRADLE_TOOLS)
        add(KOTLIN_GRADLE)
        add(DAGGER_HILT)
        add(KOTLINX_SERIALIZATION)
    }
}