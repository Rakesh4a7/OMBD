package com.rakesh.omdb.network

import com.rakesh.omdb.network.responsedaos.MovieDetailsResponseDao
import com.rakesh.omdb.network.responsedaos.MoviesListResponseDao
import io.reactivex.Observable

interface RestRepositoryInterface{
    fun searchMoviesFor(s: String, page: Int): Observable<MoviesListResponseDao>
    fun getMovieDetailsForImdbId(imdbId: String): Observable<MovieDetailsResponseDao>
}