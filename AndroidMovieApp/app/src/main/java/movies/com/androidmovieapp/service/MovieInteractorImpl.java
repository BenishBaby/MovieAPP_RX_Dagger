package movies.com.androidmovieapp.service;

import javax.inject.Inject;

import movies.com.androidmovieapp.Model.CollectionDetails;
import movies.com.androidmovieapp.Model.MovieDetails;
import movies.com.androidmovieapp.Model.NowPlayingMoviesDetails;
import movies.com.androidmovieapp.Model.NowPlayingMoviesResults;
import movies.com.androidmovieapp.util.Properties;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class MovieInteractorImpl implements MovieInteractor {

    private MovieService movieService;

    public Service service;

    private CompositeSubscription subscriptions;

    public MovieInteractorImpl() {
        this.subscriptions = new CompositeSubscription();
    }

    public MovieInteractorImpl(Service service) {
        this.service = service;
        this.subscriptions = new CompositeSubscription();
    }


    public MovieInteractorImpl(MovieService movieService) {
        if (this.movieService == null) {
            this.movieService = new MovieService();
        }
    }

    @Override
    public void fetchNowPlayingMovies(final NowPlayingMoviesAPIFinishedListener listener) {

        Subscription subscription = service.getNowPlayingMovieList(new Service.GetNowPlayingMovieListCallback() {
            @Override
            public void onSuccess(NowPlayingMoviesDetails nowPlayingMoviesDetails) {

                if(nowPlayingMoviesDetails != null) {
                    if (nowPlayingMoviesDetails.getResults() != null ) {
                        NowPlayingMoviesResults[] results = nowPlayingMoviesDetails.getResults();
                        listener.onSuccess(results);
                    }
                } else {
                    listener.onNowPlayingMoviesAPIFetchError();
                }
            }

            @Override
            public void onError() {

                listener.onNowPlayingMoviesAPIFetchError();

            }
        });

        subscriptions.add(subscription);
    }



    @Override
    public void fetchMovieDetails(final MovieDetailsAPIFinishedListener listener,String movieId){

        Subscription subscription = service.getMovieDetails(movieId,new Service.GetMovieDetailsCallback() {
            @Override
            public void onSuccess(MovieDetails moviesDetails) {

                if(moviesDetails != null) {

                        listener.onSuccess(moviesDetails);

                } else {
                    listener.onMovieDetailAPIFetchError();
                }
            }

            @Override
            public void onError() {

                listener.onMovieDetailAPIFetchError();
            }
        });

        subscriptions.add(subscription);
    }

    @Override
    public void fetchMovieCollection(final MovieCollectionsAPIFinishedListener listener,String collectionId) {

        Subscription subscription = service.getMovieCollectionDetails(collectionId, new Service.GetMovieCollectionCallback() {
            @Override
            public void onSuccess(CollectionDetails collectionDetails) {

                if (collectionDetails != null) {

                    listener.onSuccess(collectionDetails);

                } else {
                    listener.onMovieCollectionAPIFetchError();
                }
            }

            @Override
            public void onError() {

                listener.onMovieCollectionAPIFetchError();
            }
        });

        subscriptions.add(subscription);

    }
}
