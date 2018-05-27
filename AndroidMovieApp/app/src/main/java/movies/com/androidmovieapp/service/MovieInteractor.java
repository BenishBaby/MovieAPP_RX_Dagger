package movies.com.androidmovieapp.service;

import movies.com.androidmovieapp.Model.CollectionDetails;
import movies.com.androidmovieapp.Model.MovieDetails;
import movies.com.androidmovieapp.Model.NowPlayingMoviesResults;

public interface MovieInteractor {



    interface NowPlayingMoviesAPIFinishedListener {
        void onNowPlayingMoviesAPIFetchError();
        void onSuccess(NowPlayingMoviesResults[] results);
    }

    interface MovieDetailsAPIFinishedListener {
        void onMovieDetailAPIFetchError();
        void onSuccess(MovieDetails movieDetails);
    }

    interface MovieCollectionsAPIFinishedListener {
        void onMovieCollectionAPIFetchError();
        void onSuccess(CollectionDetails collectionDetails);
    }

    void fetchNowPlayingMovies(NowPlayingMoviesAPIFinishedListener listener);
    void fetchMovieDetails(MovieDetailsAPIFinishedListener listener,String movieId);
    void fetchMovieCollection(MovieCollectionsAPIFinishedListener listener,String collectionId);

}
