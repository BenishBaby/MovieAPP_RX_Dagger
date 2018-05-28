package movies.com.androidmovieapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import movies.com.androidmovieapp.Model.NowPlayingMoviesResults;
import movies.com.androidmovieapp.presenter.NowPlayingMoviePresenterImpl;
import movies.com.androidmovieapp.service.MovieInteractor;
import movies.com.androidmovieapp.view.NowPlayingMovieView;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class NowPlayingMoviePresenterTest {

    @Mock
    NowPlayingMovieView view;
    @Mock
    MovieInteractor interactor;



    private NowPlayingMoviePresenterImpl presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new NowPlayingMoviePresenterImpl(view, interactor);
    }

    @Test
    public void checkIfShowsProgressOnFetchingNowPlayingMovies() {
        presenter.fetchNowPlayingMovies();
        verify(view, times(1)).showProgress();
    }

    @Test
    public void checkIfhideProgressOnSuccess() {
        presenter.onNowPlayingMoviesAPIFetchError();
        verify(view, times(1)).hideProgress();
    }

    @Test
    public void checkIfShowsMessageOnItemClick() {
        presenter.onItemClicked(anyString());
        verify(view, times(1)).naviageToDetailPage(anyString());
    }

    @Test
    public void checkIfViewIsReleasedOnDestroy() {
        presenter.onDestroy();
        assertNull(presenter.getNowPlayingMovieView());
    }
}