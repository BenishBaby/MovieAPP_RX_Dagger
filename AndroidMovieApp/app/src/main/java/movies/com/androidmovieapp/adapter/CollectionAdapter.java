package movies.com.androidmovieapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import butterknife.BindView;
import butterknife.ButterKnife;
import movies.com.androidmovieapp.Model.Parts;
import movies.com.androidmovieapp.R;
import movies.com.androidmovieapp.presenter.MovieDetailPresenter;
import movies.com.androidmovieapp.util.Properties;

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.ViewHolder> {
    private Parts[] values;
    private Context mContext;
    private MovieDetailPresenter movieDetailPresenter;


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.movieTitleTextView)
        TextView movieTitle;
        @BindView(R.id.moviePosterImage)
        public ImageView moviePoster;

        public View layout;


        public ViewHolder(View v) {
            super(v);
            layout = v;
            ButterKnife.bind(this, v);
        }
    }

    public CollectionAdapter(Parts[] myDataset, Context context,MovieDetailPresenter movieDetailPresenter) {
        values = myDataset;
        this.mContext = context;
        this.movieDetailPresenter = movieDetailPresenter;
    }

    @Override
    public CollectionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View convertView =
                inflater.inflate(R.layout.collection_recyclerview_layout, parent, false);
        ViewHolder vh = new ViewHolder(convertView);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movieDetailPresenter.onItemClicked(values[position].getId());
            }
        });
        final Parts part = values[position];
        holder.movieTitle.setText(part.getTitle());
        Glide.with(mContext)
                .load(Properties.BASE_IMAGE_URL + part.getBackdrop_path())
                .placeholder(R.drawable.ic_launcher_background)
                .into( holder.moviePoster);
    }

    @Override
    public int getItemCount() {
        return values.length;
    }

}