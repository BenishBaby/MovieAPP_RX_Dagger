package movies.com.androidmovieapp.service;


import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import movies.com.androidmovieapp.activities.MovieDetailActivity;
import movies.com.androidmovieapp.activities.NowPlayingMoviesActivity;

@Singleton
@Component(modules = {NetworkModule.class,})
public interface Deps {
    void inject(NowPlayingMoviesActivity homeActivity);

    void inject(MovieDetailActivity movieDetailActivity);
}