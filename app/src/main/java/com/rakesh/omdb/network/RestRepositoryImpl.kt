package com.rakesh.omdb.network

import com.rakesh.omdb.network.responsedaos.MovieDetailsResponseDao
import com.rakesh.omdb.network.responsedaos.MoviesListResponseDao
import io.reactivex.Observable
import javax.inject.Inject

class RestRepositoryImpl @Inject constructor (private val api: ApiCalls):
    RestRepositoryInterface {

    override fun searchMoviesFor(s: String, page: Int): Observable<MoviesListResponseDao> {
        return api.searchMoviesFor(s, page)
    }

    override fun getMovieDetailsForImdbId(imdbId: String): Observable<MovieDetailsResponseDao> {
        return api.getMovieDetailsForImdbId(imdbId)
    }
}