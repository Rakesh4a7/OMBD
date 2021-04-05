package com.rakesh.omdb.dagger

import com.rakesh.omdb.ui.base.BaseViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, SchedulersModule::class])
interface AppComponent {

    fun inject(viewModel: BaseViewModel)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        fun networkModule(networkModule: NetworkModule): Builder
        fun rxSchedulersModule(rxSchedulersModule: SchedulersModule): Builder
    }
}