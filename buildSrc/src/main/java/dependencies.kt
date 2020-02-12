
object CoreDependencies {
    val gradleAndroid = "com.android.tools.build:gradle:${BuildVersions.androidGradle}"
    val gradleKotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
    val navigationSafe =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
    val googlePlay = "com.google.gms:google-services:${BuildVersions.googleServices}"
    val fabric = "io.fabric.tools:gradle:${BuildVersions.fabric}"
    val gradleVersions =
        "com.github.ben-manes:gradle-versions-plugin:${BuildVersions.gradleVersions}"
}

object Dependencies {

    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Kotlin.version}"


    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    val okhttpLogger =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpLoggingInterceptor}"

    /*Firebase*/
    val firebaseCore = "com.google.firebase:firebase-core:${Versions.firebaseCore}"
    val firebaseAnalytics = "com.google.firebase:firebase-analytics:${Versions.firebaseCore}"
    val firebaseCrashlytics = "com.crashlytics.sdk.android:crashlytics:${Versions.firebaseCrashlytics}"
    val firebaseAuth = "com.google.firebase:firebase-auth:${Versions.firebaseAuth}"
    val firebaseStorage = "com.google.firebase:firebase-storage:19.1.0"
    val firebaseFireStore = "com.google.firebase:firebase-firestore:21.3.1"
    val firebasePerformance = "com.google.firebase:firebase-perf:19.0.4"
    val servicesAuth = "com.google.android.gms:play-services-auth:17.0.0"
    val rxFirebaseAuthKotlin = "com.androidhuman.rxfirebase2:firebase-auth-kotlin:${Versions.rxFirebaseAuthKotlin}"
    val rxFirebaseAuth = "com.androidhuman.rxfirebase2:firebase-auth:${Versions.rxFirebaseAuth}"
    val rxFirebaseCore = "com.androidhuman.rxfirebase2:firebase-core:${Versions.rxFirebaseCore}"
    /*Firebase*/

    val appCompat = "androidx.appcompat:appcompat:${Versions.supportLibrary}"
    val cardView = "androidx.cardview:cardview:${Versions.cardView}"
    val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    val materialDesign = "com.google.android.material:material:${Versions.material}"
    val androidxCore = "androidx.core:core-ktx:${Versions.androidxCore}"
    val constraintLayout =
        "com.android.support.constraint:constraint-layout:${Versions.constraintLayout}"

    val androidWorker = "androidx.work:work-runtime-ktx:${Versions.workerManager}"
    val androidRxWorker = "androidx.work:work-rxjava2:${Versions.workerManager}"

    val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJava}"
    val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"
    val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    val rxJavaPaging = "android.arch.paging:rxjava2:${Versions.rxPaging}"
    val rxJavaRetrofit = "com.squareup.retrofit2:adapter-rxjava2:${Versions.rxRetrofitAdapter}"


    /* Architecture Components */
    val lifeCycle = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val lifeCycleKapt = "androidx.lifecycle:lifecycle-compiler:$${Versions.lifecycle}"

    val pagging = "androidx.paging:paging-runtime:${Versions.paging}"

    val room = "androidx.room:room-runtime:${Versions.room}"
    val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    val roomRxJava = "androidx.room:room-rxjava2:${Versions.room}"


    val navigationClassPath =
        "android.arch.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationClassPath}"
    val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"


    val koin = "org.koin:koin-core:${Versions.koin}"
    val koinAndorid = "org.koin:koin-android:${Versions.koin}"
    val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    val ktlint = "com.pinterest:ktlint:${Versions.ktlint}"


    val lottie = "com.airbnb.android:lottie:${Versions.lottie}"

    val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"


    val coil = "io.coil-kt:coil:0.9.1"

}


object TestDependencies {

    val jUnit = "androidx.test.ext:junit:${TestVersions.androidxJunit}"
    val assertJ = "org.assertj:assertj-core:${TestVersions.assertJ}"
    val mockk = "io.mockk:mockk:${TestVersions.mockk}"
    val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${TestVersions.coroutinesTest}"
    val mockkAndroid = "io.mockk:mockk-android:${TestVersions.mockkAndroid}"

    val roomTesting = "androidx.room:room-testing:$${Versions.room}"


    val androidTestCore = "androidx.test:core:${TestVersions.androidTestArchCore}"
    val androidTestRunner = "androidx.test:runner:${TestVersions.androidTextRunner}"
    val androidTestRules = "androidx.test:rules:${TestVersions.androidTextRules}"
    val espresso = "androidx.test.espresso:espresso-core:${TestVersions.espresso}"
    val coreTesting = "androidx.arch.core:core-testing:${TestVersions.coreTesting}"
    val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.okHttp}"

}


object AndroidModule {

    val main = listOf(
        Dependencies.kotlinStdLib,
        Dependencies.appCompat,
        Dependencies.lifeCycle,
        Dependencies.navigationFragment,
        Dependencies.navigationUiKtx,
        Dependencies.cardView,
        Dependencies.recyclerView,
        Dependencies.materialDesign,
        Dependencies.koin,
        Dependencies.koinAndorid,
        Dependencies.koinViewModel
    )

    val room = listOf(
        Dependencies.room,
        Dependencies.roomCompiler,
        Dependencies.roomRxJava
    )

    val retrofit = listOf(
        Dependencies.retrofit,
        Dependencies.gson,
        Dependencies.gsonConverter,
        Dependencies.okhttp,
        Dependencies.okhttpLogger
    )

    val firebase = listOf(
        Dependencies.firebaseCore,
        Dependencies.firebaseAnalytics,
        Dependencies.firebaseCrashlytics
    )

    val unitTesting = listOf(
        TestDependencies.jUnit,
        TestDependencies.assertJ,
        TestDependencies.mockk,
        TestDependencies.coroutinesTest,
        TestDependencies.coreTesting
    )

    val androidTesting = listOf(
        TestDependencies.androidTestCore,
        TestDependencies.androidTestRules,
        TestDependencies.androidTestRunner,
        TestDependencies.mockkAndroid,
        TestDependencies.espresso
    )
}