package movies.com.androidmovieapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import movies.com.androidmovieapp.R;
import movies.com.androidmovieapp.presenter.NowPlayingMoviePresenter;

public class MovieGridAdapter extends ArrayAdapter<MovieItem> {

    private Context mContext;
    private NowPlayingMoviePresenter nowPlayingMoviePresenter;

    class ViewHolder {
        @BindView(R.id.nowplaying_movie_poster) ImageView thumbnailImageView;
        @BindView (R.id.nowplaying_movieTitle) TextView nameTextView;
        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    private int layoutResourceId;

    public MovieGridAdapter(Context context, int layoutResourceId, ArrayList<MovieItem> objects, NowPlayingMoviePresenter nowPlayingMoviePresenter) {
        super(context, layoutResourceId, objects);
        this.layoutResourceId = layoutResourceId;
        this.mContext = context;
        this.nowPlayingMoviePresenter = nowPlayingMoviePresenter;
    }

    @Override public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if(convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            LayoutInflater inflater = (LayoutInflater.from(getContext()));
            convertView = inflater.inflate(layoutResourceId, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    nowPlayingMoviePresenter.onItemClicked(getItem(position).getMovieId());
                }
            });
        }

        MovieItem item = getItem(position);
        viewHolder.nameTextView.setText(item.getmTitle());
        Glide.with(mContext)
                .load(item.getmUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .into( viewHolder.thumbnailImageView);


        return convertView;
    }
}