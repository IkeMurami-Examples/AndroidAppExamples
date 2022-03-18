object Libs {
    object Project {
        // Здесь перечисляем наши модули и библиотеки
        const val android_library = ":androidlibrary"
    }

    object Gradle {
        private const val ver_gradle = "7.1.2"
        const val tools_build = "com.android.tools.build:gradle:$ver_gradle"

        private const val ver_kotlin_gradle = "1.5.30"
        const val kotlin_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$ver_kotlin_gradle"
    }

    object Kotlin {
        // Фиксируем версию котлина
        private const val ver_kotlin = "1.4.32"
        const val stdlib_jdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$ver_kotlin"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:$ver_kotlin"
    }

    object AndroidX {
        // androidx-зависимости
        private const val ver_appcompat = "1.2.0"
        const val appcompat = "androidx.appcompat:appcompat:$ver_appcompat"

        private const val ver_core_ktx = "1.3.2"
        const val coreKtx = "androidx.core:core-ktx:$ver_core_ktx"

        private const val ver_multidex = "2.0.1"
        const val multidex = "androidx.multidex:multidex:$ver_multidex"

        private const val ver_constraintlayout = "2.1.3"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:$ver_constraintlayout"

        private const val ver_core = "1.3.2"
        const val coreX = "androidx.core:core:$ver_core"
    }

    object Rx {
        // Rx-зависимости
    }

    object Koin {
        internal const val ver_koin = "3.1.5"
        const val core = "io.insert-koin:koin-core:$ver_koin"
        const val core_ext = "io.insert-koin:koin-core-ext:$ver_koin"
        const val android = "io.insert-koin:koin-android:$ver_koin"
        const val androidx_scope = "io.insert-koin:koin-androidx-scope:$ver_koin"
        const val androidx_viewmodel = "io.insert-koin:koin-androidx-viewmodel:$ver_koin"
    }

    object Material {
        private const val ver_material = "1.3.0-beta01"
        const val material = "com.google.android.material:material:$ver_material"

    }

    object Coroutines {
        private const val ver_core = "1.4.3"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$ver_core"
        const val rx2 = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:$ver_core"
        const val rx3 = "org.jetbrains.kotlinx:kotlinx-coroutines-rx3:$ver_core"
    }

    object Gson {
        private const val ver_gson = "2.8.6"
        const val gson = "com.google.code.gson:gson:$ver_gson"
    }

    object Test {
        const val koin = "io.insert-koin:koin-test:${Koin.ver_koin}"

        private const val ver_junit = "4.12"
        const val junit = "junit:junit:$ver_junit"

        private const val ver_junit_ext = "1.1.1"
        const val junit_ext = "androidx.test.ext:junit:$ver_junit_ext"

        private const val ver_espresso = "3.4.0"
        const val espresso_core = "androidx.test.espresso:espresso-core:$ver_espresso"
    }
}