package com.example.nikolaiturev.finallyproject.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import java.util.concurrent.TimeUnit

val dataModule = module {

    single<OkHttpClient> {
        val logsInterceptor = HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        OkHttpClient.Builder()
            .addInterceptor(logsInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    single<Gson> {
        GsonBuilder()
            .setPrettyPrinting()
            .excludeFieldsWithoutExposeAnnotation()
            .enableComplexMapKeySerialization()
            .setVersion(1.0)
            .create()
    }

//    single<WeatherApi> {
//        Retrofit.Builder()
//            .baseUrl(BuildConfig.API_URL)
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(get())
//            .build()
//            .create(WeatherApi::class.java)
//    }
}

