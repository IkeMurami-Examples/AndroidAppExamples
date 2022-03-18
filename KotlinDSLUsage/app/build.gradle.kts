/*
    Есть два синтаксиса — *.gradle и *.gradle.kts
    Первый – это Groovy DSL синтаксис
    Второй – это Kotlin DSL синтаксис.
* */

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

/*
Include local gradle files

apply {
    from("$rootDir/gradle/version.gradle.kts")
}

 */

buildscript {
    repositories {
        google()
    }

    dependencies {

    }
}


android {
    /// compileSdkVersion(versions.android.targetSDK)

    compileSdk = Versions.target_sdk

    lintOptions {
        isCheckDependencies = true
        isAbortOnError = false
    }

    defaultConfig {
        minSdk = Versions.min_sdk
        targetSdk = Versions.target_sdk

        versionCode = Versions.build_number
        versionName = Versions.version_number

        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    sourceSets {
        named("main") {
            java.srcDirs("src/main/kotlin", "src/main/java")
        }
        named("test") {
            java.srcDirs("src/test/kotlin")
        }
        named("androidTest") {
            java.srcDirs("src/androidTest/kotlin")
        }
    }

    flavorDimensions("mode1")
    flavorDimensions("mode2")
    productFlavors {
        create("production") {
            dimension = "mode1"
            applicationId = "ike.murami.example_koin_app"
            resValue("string", "some_param", "text_value")
        }
        create("demo") {
            dimension = "mode1"
            applicationId = "demo.ike.murami.example_koin_app"
            resValue("string", "some_param", "text_value")
        }
        create("someFlavor") {
            dimension = "mode2"
            applicationId = "blabla.ike.murami.example_koin_app"
            resValue("string", "some_param", "text_value")
        }
    }


    /*
    * Такая нотация работает во всех словарях в kotlin dsl:
    *
    *   named — обращаемся к существующему значению
    *   register — регистрируем новое
    *   create — создаем новое (в чем отличие от register?)
    * */

    signingConfigs {
        named("debug").configure {
            storeFile = file("debug.jks")
            storePassword = "debugPassword"
            keyAlias = "debugAlias"
            keyPassword = "debugPassword"
            isV1SigningEnabled = true
            isV2SigningEnabled = true
        }
        register("release") {
            // ...
        }
        create("debug12341") {
            // ...
        }
    }

    compileOptions {
        sourceCompatibility = Versions.java_version
        targetCompatibility = Versions.java_version
    }

    kotlinOptions {
        jvmTarget = Versions.jvm_version  // https://kotlinlang.org/docs/gradle.html#gradle-java-toolchains-support
    }

    packagingOptions {
        exclude("META-INF/io.netty.versions.properties")
        exclude("META-INF/INDEX.LIST")
        exclude("META-INF/*.kotlin_module")
        exclude("META-INF/**")
        exclude("mozilla/*")
        pickFirst("**.so")
    }

    buildTypes {
        debug {
            ndk {
                abiFilters.add("arm64-v8a")
                abiFilters.add("armeabi-v7a")
                abiFilters.add("x86")       // For emulators
                abiFilters.add("x86_64")    // For emulators
            }
            resValue("string", "app_version_name", "${defaultConfig.versionName}")
            resValue("string", "app_version_code", "${defaultConfig.versionCode}")
            resValue("string", "app_version_full", "${defaultConfig.versionName}-${defaultConfig.versionCode}-debug")
            buildConfigField("String", "HOST_URL", "${Configs.BuildConfig.hostUrl}")
            signingConfig = signingConfigs.getByName("debug")
            isDebuggable = true
        }
        release {
            ndk {
                abiFilters.add("arm64-v8a")
                abiFilters.add("armeabi-v7a")
            }
            resValue("string", "app_version_name", "${defaultConfig.versionName}")
            resValue("string", "app_version_code", "${defaultConfig.versionCode}")
            resValue("string", "app_version_full", "${defaultConfig.versionName}-${defaultConfig.versionCode}-release")
            buildConfigField("String", "HOST_URL", "${Configs.BuildConfig.hostUrl}")

            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(project(Libs.Project.android_library))

    implementation(Libs.AndroidX.appcompat)
    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.constraintlayout)
    implementation(Libs.Material.material)
    implementation(Libs.AndroidX.multidex)

    // Koin
    implementation(Libs.Koin.android)
    implementation(Libs.Koin.core)
    implementation(Libs.Koin.core_ext)

    //Gson
    implementation(Libs.Gson.gson)

    testImplementation(Libs.Test.junit)
    androidTestImplementation(Libs.Test.junit_ext)
}