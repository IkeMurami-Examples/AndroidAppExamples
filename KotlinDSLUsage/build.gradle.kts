// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        // Сюда только зависимости для сборки проекта, не для самой логики!
        classpath(Libs.Gradle.tools_build)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}