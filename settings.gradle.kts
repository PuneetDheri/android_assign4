pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            if( requested.id.id.equals("com.google.dagger.hilt.android")) {
                useModule("com.google.dagger:hilt-android-gradle-plugin:2.48.1")
            }
        }
    }
}


dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Assignment4"
include(":app")
