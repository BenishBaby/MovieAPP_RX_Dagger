package movies.com.androidmovieapp.presenter;

import javax.inject.Inject;

import movies.com.androidmovieapp.Model.CollectionDetails;
import movies.com.androidmovieapp.Model.MovieDetails;
import movies.com.androidmovieapp.service.MovieInteractor;
import movies.com.androidmovieapp.service.Service;
import movies.com.androidmovieapp.view.MovieDetailView;

public class MovieDetailPresenterImpl implements MovieDetailPresenter,MovieInteractor.MovieDetailsAPIFinishedListener, MovieInteractor.MovieCollectionsAPIFinishedListener {

    private MovieDetailView movieDetailView;
    private MovieInteractor movieInteractor;


    public MovieDetailPresenterImpl(MovieDetailView movieDetailView, MovieInteractor movieInteractor) {
        this.movieDetailView = movieDetailView;
        this.movieInteractor = movieInteractor;
    }

    @Override
    public void loadMovieDetails(String movieId) {

        if (movieDetailView != null) {
            movieDetailView.showProgress();
        }
        movieInteractor.fetchMovieDetails(this,movieId);
    }

    @Override
    public void loadMovieCollection(String collectionId) {

        if (movieDetailView != null) {
            movieDetailView.showProgress();
        }
        movieInteractor.fetchMovieCollection(this,collectionId);
    }

    @Override
    public void onItemClicked(String movieId) {

        if (movieDetailView != null) {
            movieDetailView.naviageToMovieDetailPage(movieId);
        }
    }

    @Override
    public void onDestroy() {
        movieDetailView = null;
    }

    @Override
    public void onMovieDetailAPIFetchError() {
        if (movieDetailView != null) {
            movieDetailView.hideProgress();
            movieDetailView.setMovieFetchError();
        }
    }

    @Override
    public void onMovieCollectionAPIFetchError() {
        if (movieDetailView != null) {
            movieDetailView.hideProgress();
            movieDetailView.setMovieCollectionFetchError();
        }
    }



    @Override
    public void onSuccess(MovieDetails movieDetails) {
        movieDetailView.hideProgress();
        if (movieDetailView != null) {
            movieDetailView.setMoviewDetails(movieDetails);
        }
    }

    @Override
    public void onSuccess(CollectionDetails collectionDetails) {
        movieDetailView.hideProgress();
        if (movieDetailView != null) {
            movieDetailView.setMoviewCollectionList(collectionDetails);
        }
    }
}
