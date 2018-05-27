package movies.com.androidmovieapp.view;

import movies.com.androidmovieapp.Model.NowPlayingMoviesResults;

public interface NowPlayingMovieView {

    void showProgress();

    void hideProgress();

    void setMovieFetchError();

    void setNowPlayingMovies(NowPlayingMoviesResults[] results);

    void naviageToDetailPage(String movieId);
}
