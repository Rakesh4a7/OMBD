package com.rakesh.omdb.network.transformers

import com.rakesh.omdb.network.responsedaos.MovieDetailsResponseDao
import com.rakesh.omdb.ui.moviedetails.MovieDetails

class MovieDetailsResponseDaoTransformer: Transformer<MovieDetailsResponseDao, MovieDetails>() {

    override fun transform(responseDao: MovieDetailsResponseDao):MovieDetails{
        var posterSub:String? = null
        listOfNotNull(
            safeValue(responseDao.year, null),
            safeValue(responseDao.rated, null),
            safeValue(responseDao.runtime, null)
        ).forEach {
            posterSub = if(posterSub == null) it else ("$posterSub  |  $it")
        }

        return MovieDetails(posterSub,
            safeValue(responseDao.writer),
            safeValue(responseDao.director),
            safeValue(responseDao.actors),
            safeValue(responseDao.imdbRating),
            safeValue(responseDao.imdbVotes, "0"),
            safeValue(responseDao.plot, null),
            safeValue(responseDao.poster),
            safeValue(responseDao.title),
            safeValue(responseDao.genre),
            safeValue(responseDao.metascore, null)
        )
    }


    private fun safeValue(value:String, defaultValue: String? = "-"):String?{
        return if(value == NA) defaultValue else value
    }

    companion object {
        const val NA="N/A"
    }

}