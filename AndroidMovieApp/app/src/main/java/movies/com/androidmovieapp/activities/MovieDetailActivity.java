package movies.com.androidmovieapp.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import movies.com.androidmovieapp.Model.CollectionDetails;
import movies.com.androidmovieapp.Model.Genres;
import movies.com.androidmovieapp.Model.MovieDetails;
import movies.com.androidmovieapp.R;
import movies.com.androidmovieapp.adapter.CollectionAdapter;
import movies.com.androidmovieapp.presenter.MovieDetailPresenter;
import movies.com.androidmovieapp.presenter.MovieDetailPresenterImpl;
import movies.com.androidmovieapp.service.BaseApp;
import movies.com.androidmovieapp.service.MovieInteractorImpl;
import movies.com.androidmovieapp.service.MovieService;
import movies.com.androidmovieapp.service.Service;
import movies.com.androidmovieapp.util.Properties;
import movies.com.androidmovieapp.view.MovieDetailView;

public class MovieDetailActivity extends BaseApp implements MovieDetailView{

    @BindView(R.id.progressBar2)
    ProgressBar progressBar;

    @BindView(R.id.movieImageView)
    ImageView imageView;

    @BindView(R.id.date)
    TextView dateView;

    @BindView(R.id.genre)
    TextView genreView;

    @BindView(R.id.title)
    TextView titleView;

    @BindView(R.id.description)
    TextView descriptionView;


    @BindView(R.id.my_recycler_view)
    RecyclerView recyclerView;

    private MovieDetailPresenter presenter;
    private Unbinder unbinder;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Inject
    public Service service;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        unbinder = ButterKnife.bind(this);
        getDeps().inject(this);
        String movieId = getIntent().getStringExtra("movieId");
        presenter = new MovieDetailPresenterImpl(this,new MovieInteractorImpl(service));
        presenter.loadMovieDetails(movieId);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setMovieFetchError() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Error Fetching Movie Details")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void setMoviewDetails(MovieDetails movieDetails) {

        Glide.with(this)
                .load(Properties.BASE_IMAGE_URL + movieDetails.getBackdrop_path())
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView);
        titleView.setText(movieDetails.getTitle());
        descriptionView.setText(movieDetails.getOverview());
        dateView.setText(movieDetails.getRelease_date());

        String genreTypes =  null;
        for(Genres genres : movieDetails.getGenres()) {
            genreTypes = genres.getName() + "/";
        }
        genreView.setText(genreTypes);
        presenter.loadMovieCollection("10");
    }

    @Override
    public void setMoviewCollectionList(CollectionDetails collectionDetails) {

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new CollectionAdapter(collectionDetails.getParts(),this,presenter);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void naviageToMovieDetailPage(String movieId) {

        Intent intent = new Intent(this, MovieDetailActivity.class);
        intent.putExtra("movieId", movieId);
        startActivity(intent);
    }
}
