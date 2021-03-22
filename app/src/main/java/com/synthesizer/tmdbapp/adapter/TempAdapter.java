package com.synthesizer.tmdbapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.synthesizer.tmdbapp.R;

public class TempAdapter extends RecyclerView.Adapter<TempAdapter.TempViewHolder> {


    @NonNull
    @Override
    public TempViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =  inflater.inflate(R.layout.temp_recyler_item,parent,false);

        return new TempViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TempViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class TempViewHolder extends RecyclerView.ViewHolder {


        public TempViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
