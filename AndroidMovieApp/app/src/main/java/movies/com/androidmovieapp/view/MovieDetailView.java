package movies.com.androidmovieapp.view;

import movies.com.androidmovieapp.Model.CollectionDetails;
import movies.com.androidmovieapp.Model.MovieDetails;
import movies.com.androidmovieapp.Model.NowPlayingMoviesResults;

public interface MovieDetailView {

    void showProgress();

    void hideProgress();

    void setMovieFetchError();

    void setMoviewDetails(MovieDetails moviewDetails);

    void setMoviewCollectionList(CollectionDetails collectionDetails);

    void naviageToMovieDetailPage(String movieId);
}
