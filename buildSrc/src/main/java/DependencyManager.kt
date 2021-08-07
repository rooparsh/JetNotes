object DependencyManager {

    val appLibraries = arrayListOf<String>().apply {
        addAll(DependencyConfig.Compose.list)
        addAll(DependencyConfig.Android.list)
        addAll(DependencyConfig.Google.list)
        addAll(DependencyConfig.Google.Di.list)
        addAll(DependencyConfig.ImageLoading.list)
    }

    val compilerLibraries = arrayListOf<String>().apply {
        addAll(DependencyConfig.Google.Di.compilerList)
    }

    val testLibraries = arrayListOf<String>().apply {
        addAll(DependencyConfig.Testing.Functional.list)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        addAll(DependencyConfig.Testing.Ui.list)
    }

    val dataLibraries = arrayListOf<String>().apply {
        addAll(DependencyConfig.Async.list)
        addAll(DependencyConfig.Networking.list)
        addAll(DependencyConfig.Google.Di.list)
    }

    val domainLibraries = arrayListOf<String>().apply {
        addAll(DependencyConfig.Async.list)
        addAll(DependencyConfig.Google.Di.list)
    }

    object Multiplatform {
        val commonLibraries = DependencyConfig.Multiplatform.Common.list
        val androidLibraries = DependencyConfig.Multiplatform.Android.list
        val iosLibraries = DependencyConfig.Multiplatform.Ios.list
    }
}