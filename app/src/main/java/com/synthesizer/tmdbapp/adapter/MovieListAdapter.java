package com.synthesizer.tmdbapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.synthesizer.tmdbapp.R;
import com.synthesizer.tmdbapp.model.Movie;

public class MovieListAdapter extends PagedListAdapter<Movie, MovieListAdapter.MovieViewHolder> {

    public MovieListAdapter(){
        super(diffCallback);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_movie_list_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = getItem(position);
        if(movie!=null) holder.bind(movie);
    }

    private static DiffUtil.ItemCallback<Movie> diffCallback = new DiffUtil.ItemCallback<Movie>() {
        @Override
        public boolean areItemsTheSame(Movie oldMovie, Movie newMovie) {
            return oldMovie.getId() == newMovie.getId();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(Movie oldMovie, @NonNull Movie newMovie) {
            return oldMovie.equals(newMovie);
        }
    };

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private Context viewHolderContext;
        private CircularProgressDrawable progressBar;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewMovieListItem);
            viewHolderContext = itemView.getContext();
            progressBar = new CircularProgressDrawable(viewHolderContext);
            progressBar.setStyle(CircularProgressDrawable.DEFAULT);
            progressBar.start();
        }

        public void bind(Movie movie){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                Glide.with(viewHolderContext)
                        .load("https://image.tmdb.org/t/p/original" + movie.getPoster_path())
                        .placeholder(progressBar)
                        .into(imageView);
            }
        }
    }
}
