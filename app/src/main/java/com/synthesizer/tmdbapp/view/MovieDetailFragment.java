package com.synthesizer.tmdbapp.view;

import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.synthesizer.tmdbapp.model.Genre;
import com.synthesizer.tmdbapp.service.response.MovieDetail;
import com.synthesizer.tmdbapp.viewmodel.MovieDetailViewModel;
import com.synthesizer.tmdbapp.R;
import com.synthesizer.tmdbapp.viewmodel.factory.MovieDetailViewModelFactory;

import java.util.ArrayList;

public class MovieDetailFragment extends Fragment {

    private MovieDetailViewModel mViewModel;
    private ImageView imageViewBackdrop;
    private ImageView imageViewPoster;
    private TextView textViewTitle;
    private TextView textViewOverview;
    private TextView textViewIMDBLink;
    private ConstraintLayout frameLayoutDetails;
    private Flow flowDetails;
    private CircularProgressDrawable progressBar;


    public static MovieDetailFragment newInstance() {
        return new MovieDetailFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.fragment_movie_detail, container, false);
        imageViewBackdrop = root.findViewById(R.id.imageViewMovieDetail_Backdrop);
        imageViewPoster = root.findViewById(R.id.imageViewMovieDetail_Poster);
        textViewTitle = root.findViewById(R.id.textViewMovieDetail_Title);
        textViewOverview = root.findViewById(R.id.textViewMovieDetail_Overview);
        textViewIMDBLink = root.findViewById(R.id.textViewMovieDetail_IMDBLink);
        frameLayoutDetails = root.findViewById(R.id.constraintLayoutMovieDetails);
        flowDetails = root.findViewById(R.id.flowMovieDetails);
        progressBar = new CircularProgressDrawable(getContext());
        progressBar.setStyle(CircularProgressDrawable.DEFAULT);
        progressBar.start();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MovieDetailViewModelFactory factory =
                new MovieDetailViewModelFactory(MovieDetailFragmentArgs
                        .fromBundle(getArguments()).getSelectedMovieID());
        mViewModel = new ViewModelProvider(this,factory).get(MovieDetailViewModel.class);
        // TODO: Use the ViewModel
        textViewIMDBLink.setMovementMethod(LinkMovementMethod.getInstance());

        observe();
    }

    private void observe(){
        mViewModel.getMovieDetail().observe(getViewLifecycleOwner(), new Observer<MovieDetail>() {
            @Override
            public void onChanged(MovieDetail movieDetail) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    Glide.with(getContext())
                            .load("https://image.tmdb.org/t/p/original" + movieDetail.getBackdrop_path())
                            .placeholder(progressBar)
                            .into(imageViewBackdrop);
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    Glide.with(getContext())
                            .load("https://image.tmdb.org/t/p/original" + movieDetail.getPoster_path())
                            .placeholder(progressBar)
                            .into(imageViewPoster);
                }

                textViewTitle.setText(movieDetail.getTitle());
                textViewOverview.setText(movieDetail.getOverview());
                for(Genre genre: movieDetail.getGenres()){
                    frameLayoutDetails.addView(createTextView(genre.getName()));
                }

                ArrayList<Integer> referencesID = new ArrayList<>();
                for(int i=0;i<frameLayoutDetails.getChildCount();i++){
                    View v = frameLayoutDetails.getChildAt(i);
                    if(v instanceof TextView){
                        referencesID.add(v.getId());
                    }
                }
                System.out.println(referencesID.size());
                int[] arr = referencesID.stream().mapToInt(i -> i).toArray();
                try{
                    flowDetails.setReferencedIds(arr);
                }catch (Exception e){
                    e.printStackTrace();
                }

                textViewIMDBLink.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                        browserIntent
                                .setData(Uri.parse("https://www.imdb.com/title/"
                                                + movieDetail.getImdb_id()));
                        startActivity(browserIntent);
                    }
                });

            }
        });
    }

    private TextView createTextView(String s){
        TextView textView = new TextView(getContext());
        textView.setText(s);
        textView.setId(View.generateViewId());
        textView.setTextColor(ContextCompat.getColor(getContext(),R.color.white));
        textView.setBackground(ContextCompat.getDrawable(getActivity(),
                R.drawable.movie_detail_text_background));
        return textView;
    }

}