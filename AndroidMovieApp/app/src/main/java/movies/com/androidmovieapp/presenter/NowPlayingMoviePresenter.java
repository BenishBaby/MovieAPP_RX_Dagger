package movies.com.androidmovieapp.presenter;

public interface NowPlayingMoviePresenter{

    void fetchNowPlayingMovies();
    public void onItemClicked(String movieId);
    void onDestroy();

}
