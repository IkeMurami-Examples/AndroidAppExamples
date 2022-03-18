plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {

    }
}

repositories {
    mavenCentral()
    google()
}


dependencies {
    compileOnly("com.android.tools.build:gradle:4.2.0")
}