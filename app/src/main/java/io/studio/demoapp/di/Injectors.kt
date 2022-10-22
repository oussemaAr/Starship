package io.studio.demoapp.di

import io.studio.demoapp.data.AppRepositoryImpl
import io.studio.demoapp.data.AppService
import io.studio.demoapp.data.NetworkClient
import io.studio.demoapp.domain.AppRepository

class Injectors {

    private val retrofit = NetworkClient.instance()

    private val service = retrofit.create(AppService::class.java)

    val repository: AppRepository = AppRepositoryImpl(service)

}