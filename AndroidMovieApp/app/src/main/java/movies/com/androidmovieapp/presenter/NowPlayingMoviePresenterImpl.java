package movies.com.androidmovieapp.presenter;

import movies.com.androidmovieapp.Model.NowPlayingMoviesResults;
import movies.com.androidmovieapp.service.MovieInteractor;
import movies.com.androidmovieapp.view.NowPlayingMovieView;

public class NowPlayingMoviePresenterImpl implements NowPlayingMoviePresenter, MovieInteractor.NowPlayingMoviesAPIFinishedListener{

    public NowPlayingMovieView getNowPlayingMovieView() {
        return nowPlayingMovieView;
    }

    private NowPlayingMovieView nowPlayingMovieView;
    public MovieInteractor nowPlayingMovieInteractor;

    public NowPlayingMoviePresenterImpl(NowPlayingMovieView nowPlayingMovieView,MovieInteractor nowPlayingMovieInteractor) {
        this.nowPlayingMovieView = nowPlayingMovieView;
        this.nowPlayingMovieInteractor = nowPlayingMovieInteractor;
    }

    @Override
    public void fetchNowPlayingMovies() {
        if (nowPlayingMovieView != null) {
            nowPlayingMovieView.showProgress();
        }
        nowPlayingMovieInteractor.fetchNowPlayingMovies(this);

    }

    @Override public void onDestroy() {
        nowPlayingMovieView = null;
    }

    @Override
    public void onNowPlayingMoviesAPIFetchError() {
        if (nowPlayingMovieView != null) {
            nowPlayingMovieView.hideProgress();
            nowPlayingMovieView.setMovieFetchError();
        }
    }

    @Override public void onSuccess(NowPlayingMoviesResults[] results) {
        if (nowPlayingMovieView != null) {
            nowPlayingMovieView.setNowPlayingMovies(results);
        }
    }

    @Override public void onItemClicked(String movieId) {

        if (nowPlayingMovieView != null) {
            nowPlayingMovieView.naviageToDetailPage(movieId);
        }
    }


}
