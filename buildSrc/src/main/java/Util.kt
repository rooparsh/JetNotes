import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.initialization.dsl.ScriptHandler
import org.gradle.internal.impldep.org.apache.maven.model.Dependency

fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}

fun DependencyHandler.api(list: List<String>) {
    list.forEach { dependency ->
        add("api", dependency)
    }
}

fun DependencyHandler.classPath(list: List<String>) {
    list.forEach { dependency ->
        add(ScriptHandler.CLASSPATH_CONFIGURATION, dependency)
    }
}