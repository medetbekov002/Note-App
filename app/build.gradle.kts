plugins {
    id(Plugins.AGP.application)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
    id(Plugins.DaggerHilt.hilt)
}

android {
    namespace = "com.example.lesson7_1"
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = "com.example.lesson7_1"
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName

        testInstrumentationRunner = AndroidConfig.androidTestInstrumentation
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_9
        targetCompatibility = JavaVersion.VERSION_1_9
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(Deps.UI.androidCore)
    implementation(Deps.UI.appcompat)
    implementation(Deps.UI.material)
    implementation(Deps.UI.constraint)
    testImplementation(Deps.UI.junit)
    androidTestImplementation(Deps.UI.extJunit)
    androidTestImplementation(Deps.UI.espresso)
    implementation(Deps.UI.fragment)

    //room
    implementation(Deps.Room.room)
    implementation(Deps.Room.roomRuntime)
    kapt(Deps.Room.compiler)

    //hilt
    implementation(Deps.DaggerHilt.hilt)
    kapt(Deps.DaggerHilt.compiler)

    //coroutines
    implementation(Deps.Coroutines.android)

    //nav component
    implementation(Deps.NavComponent.fragment)
    implementation(Deps.NavComponent.ui)

    //view Binding property delegate (reflection-free flavor)
    implementation(Deps.ViewBindingDelegate.viewBindingDelegate)

    //lifecycle
    implementation(Deps.Lifecycle.lifecycle)
}