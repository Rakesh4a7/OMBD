package com.rakesh.omdb

import android.app.Application
import com.rakesh.omdb.dagger.AppComponent
import com.rakesh.omdb.dagger.DaggerAppComponent
import com.rakesh.omdb.dagger.NetworkModule
import com.rakesh.omdb.dagger.SchedulersModule
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {
    companion object{
        private var appComponent: AppComponent? = null

        fun getInjector(): AppComponent {
            if(appComponent == null){
                appComponent = DaggerAppComponent
                    .builder()
                    .networkModule(NetworkModule)
                    .rxSchedulersModule(SchedulersModule)
                    .build()
            }
            return appComponent as AppComponent
        }

    }
}