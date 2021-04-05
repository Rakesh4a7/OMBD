package com.rakesh.omdb.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Scheduler
import com.rakesh.omdb.dagger.SchedulersModule
import com.rakesh.omdb.network.RestRepositoryInterface
import com.rakesh.omdb.App
import javax.inject.Inject

abstract class BaseViewModel: ViewModel(){

    @SchedulersModule.IoScheduler
    @Inject
    lateinit var ioScheduler:Scheduler

    @SchedulersModule.MainThreadScheduler
    @Inject
    lateinit var mainThreadScheduler:Scheduler

    @Inject
    lateinit var restRepository: RestRepositoryInterface

    val isApiCallActive: MutableLiveData<Boolean> = MutableLiveData()

    fun setApiCallActive(apiCallActive: Boolean){
        if(isApiCallActive.value!=apiCallActive) {
            isApiCallActive.value = apiCallActive
        }
    }

    init {
        App.getInjector().inject(this)
    }

}