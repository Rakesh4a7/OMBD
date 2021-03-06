package com.rakesh.omdb.network

import com.rakesh.omdb.network.responsedaos.MovieDetailsResponseDao
import com.rakesh.omdb.network.responsedaos.MoviesListResponseDao
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCalls {
    @GET("./")
    fun searchMoviesFor(@Query("s") s:String, @Query("page") page: Int): Observable<MoviesListResponseDao>

    @GET("./")
    fun getMovieDetailsForImdbId(@Query("i") imdbId:String): Observable<MovieDetailsResponseDao>
}