package movies.com.androidmovieapp.service;


import movies.com.androidmovieapp.Model.CollectionDetails;
import movies.com.androidmovieapp.Model.MovieDetails;
import movies.com.androidmovieapp.Model.NowPlayingMoviesDetails;
import movies.com.androidmovieapp.util.Properties;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class Service {
    private final MovieDbApi movieDbApi;

    public Service(MovieDbApi movieDbApi) {
        this.movieDbApi = movieDbApi;
    }

    public Subscription getNowPlayingMovieList(final GetNowPlayingMovieListCallback callback) {

        return movieDbApi.getNowPlayingMovies(Properties.MOVIE_DB_API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends NowPlayingMoviesDetails>>() {
                    @Override
                    public Observable<? extends NowPlayingMoviesDetails> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<NowPlayingMoviesDetails>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError();

                    }

                    @Override
                    public void onNext(NowPlayingMoviesDetails nowPlayingMoviesDetails) {
                        callback.onSuccess(nowPlayingMoviesDetails);
                    }
                });
    }

    public Subscription getMovieDetails( String movieId,final GetMovieDetailsCallback callback) {

        return movieDbApi.getMovieDetails(movieId,Properties.MOVIE_DB_API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends MovieDetails>>() {
                    @Override
                    public Observable<? extends MovieDetails> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<MovieDetails>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError();

                    }

                    @Override
                    public void onNext(MovieDetails movieDetails) {
                        callback.onSuccess(movieDetails);
                    }
                });
    }

    public Subscription getMovieCollectionDetails( String collectionId,final GetMovieCollectionCallback callback) {

        return movieDbApi.getMovieCollection(collectionId,Properties.MOVIE_DB_API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends CollectionDetails>>() {
                    @Override
                    public Observable<? extends CollectionDetails> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<CollectionDetails>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onError();

                    }

                    @Override
                    public void onNext(CollectionDetails collectionDetails) {
                        callback.onSuccess(collectionDetails);
                    }
                });
    }

    public interface GetNowPlayingMovieListCallback{
        void onSuccess(NowPlayingMoviesDetails nowPlayingMoviesDetails);
        void onError();
    }

    public interface GetMovieDetailsCallback{
        void onSuccess(MovieDetails movieDetails);
        void onError();
    }

    public interface GetMovieCollectionCallback{
        void onSuccess(CollectionDetails collectionDetails);
        void onError();
    }
}