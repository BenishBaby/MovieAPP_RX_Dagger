package movies.com.androidmovieapp.presenter;

public interface MovieDetailPresenter {

    public void loadMovieDetails(String movieId);
    public void loadMovieCollection(String collectionId);
    public void onItemClicked(String movieId);
    public void onDestroy();
}
