package com.rakesh.omdb.dagger

import com.rakesh.omdb.network.ApiCalls
import com.rakesh.omdb.network.RestRepositoryImpl
import com.rakesh.omdb.network.RestRepositoryInterface
import com.rakesh.omdb.network.RetrofitBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import io.reactivex.Scheduler
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    internal fun provideApiCalls(retrofit: Retrofit): ApiCalls {
        return retrofit.create(ApiCalls::class.java)
    }

    @Singleton
    @Provides
    internal fun provideRetrofit(@SchedulersModule.IoScheduler scheduler:Scheduler): Retrofit {
        return RetrofitBuilder(scheduler).retrofit
    }

    @Singleton
    @Provides
    internal fun provideRestRepository(apiCalls: ApiCalls): RestRepositoryInterface {
        return RestRepositoryImpl(apiCalls)
    }

}