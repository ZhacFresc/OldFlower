package com.example.ianenavizhyjavascript;

import android.content.Context;
import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.ViewHolder> {
    private final static String PHOTO_URL = "http://services.hanselandpetal.com/photos/";
    private List<Flower> mFlowers;
    public Context mContext;

    FlowerAdapter(List<Flower> flowers) {

        this.mFlowers = flowers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.first_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Flower flower = mFlowers.get(position);
        holder.nameTextView.setText(flower.getName());

        Picasso.get().load(PHOTO_URL + flower.getPhoto()).into(holder.flowerImageView);
        System.err.println(PHOTO_URL + flower.getPhoto());


    }

    @Override
    public int getItemCount() {
        if (mFlowers == null) {
            return 0;
        }
        return mFlowers.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        ImageView flowerImageView;

        ViewHolder(View itemView) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            flowerImageView = (ImageView) itemView.findViewById(R.id.itemImageView);
        }
    }
}
