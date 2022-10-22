package io.studio.demoapp.data

import io.studio.demoapp.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkClient {


    companion object {
        private var instance: Retrofit? = null

        @Synchronized
        fun instance(): Retrofit {
            if (instance == null) {
                instance = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return instance!!
        }
    }
}