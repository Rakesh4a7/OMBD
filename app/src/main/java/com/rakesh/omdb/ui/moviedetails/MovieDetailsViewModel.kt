package com.rakesh.omdb.ui.moviedetails

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.rakesh.omdb.network.responsedaos.MovieDetailsResponseDao
import com.rakesh.omdb.network.transformers.MovieDetailsResponseDaoTransformer
import com.rakesh.omdb.ui.base.BaseViewModel
import io.reactivex.disposables.Disposable

class MovieDetailsViewModel @ViewModelInject constructor(): BaseViewModel(){

    val movieDetails:MutableLiveData<MovieDetails> = MutableLiveData()
    private val transformer = MovieDetailsResponseDaoTransformer()
    private var subscription: Disposable? = null

    override fun onCleared() {
        super.onCleared()
        subscription?.dispose()
    }

    fun getMovieDetails(imdbId:String){
        subscription?.dispose()
        subscription = restRepository.getMovieDetailsForImdbId(imdbId)
            .subscribeOn(ioScheduler)
            .observeOn(mainThreadScheduler)
            .doOnSubscribe { setApiCallActive(true) }
            .doOnTerminate { setApiCallActive(false) }
            .subscribe(
                { result -> onRetrievePostListSuccess(result) },
                { onRetrieveMovieListDaoError() }
            )
    }

    private fun onRetrievePostListSuccess(movieDetailsResponseResponseDao: MovieDetailsResponseDao){
        movieDetails.value = transformer.transform(movieDetailsResponseResponseDao)
    }

    private fun onRetrieveMovieListDaoError(){
        setApiCallActive(false)
        movieDetails.value = null
    }
}
