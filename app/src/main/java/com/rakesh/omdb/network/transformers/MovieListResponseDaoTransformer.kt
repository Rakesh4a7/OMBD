package com.rakesh.omdb.network.transformers

import com.rakesh.omdb.network.responsedaos.MoviesListResponseDao
import com.rakesh.omdb.ui.moviesearch.Movie

class MovieListResponseDaoTransformer: Transformer<MoviesListResponseDao, List<Movie>>() {

    override fun transform(responseDao: MoviesListResponseDao):List<Movie>{
        return responseDao.movieResponseDaos?.map { movie -> Movie(movie.imdbID, movie.poster, movie.title, movie.year) }?:ArrayList()
    }

}