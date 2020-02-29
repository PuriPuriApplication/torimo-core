package com.ppap.torimocore.infrastructure.apiclient

import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.TlsVersion
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * 外部APIのFactoryクラスです
 * api-client.xmlから呼び出され,DIされるのを想定しています
 */
class APIClientFactory {

    companion object {
        fun <T> create(endpoint: String, resourceClass: Class<T>): T {
            if (endpoint.isNullOrEmpty()) throw RuntimeException()

            // setting HttpClient
            val spec = ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                    .tlsVersions(TlsVersion.TLS_1_0, TlsVersion.TLS_1_1, TlsVersion.TLS_1_2, TlsVersion.SSL_3_0)
                    .build()
            val okHttpClient = OkHttpClient().newBuilder()
                    .connectionSpecs(listOf(spec))
                    .readTimeout(APIConfigure.readTimeout)
                    .writeTimeout(APIConfigure.writeTimeout)
                    .connectTimeout(APIConfigure.connectTimeout)
                    .build()

            return Retrofit.Builder()
                    .baseUrl(endpoint)
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(resourceClass)
        }
    }
}
